package io.github.yak33.web.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.stp.parameter.SaLoginParameter;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.github.yak33.common.core.constant.Constants;
import io.github.yak33.common.core.constant.GlobalConstants;
import io.github.yak33.common.core.constant.SystemConstants;
import io.github.yak33.common.core.domain.model.EmailLoginBody;
import io.github.yak33.common.core.domain.model.LoginUser;
import io.github.yak33.common.core.enums.LoginType;
import io.github.yak33.common.core.exception.user.CaptchaExpireException;
import io.github.yak33.common.core.exception.user.UserException;
import io.github.yak33.common.core.utils.MessageUtils;
import io.github.yak33.common.core.utils.StringUtils;
import io.github.yak33.common.core.utils.ValidatorUtils;
import io.github.yak33.common.json.utils.JsonUtils;
import io.github.yak33.common.redis.utils.RedisUtils;
import io.github.yak33.common.satoken.utils.LoginHelper;
import io.github.yak33.common.tenant.helper.TenantHelper;
import io.github.yak33.system.domain.SysUser;
import io.github.yak33.system.domain.vo.SysClientVo;
import io.github.yak33.system.domain.vo.SysUserVo;
import io.github.yak33.system.mapper.SysUserMapper;
import io.github.yak33.web.domain.vo.LoginVo;
import io.github.yak33.web.service.IAuthStrategy;
import io.github.yak33.web.service.SysLoginService;
import org.springframework.stereotype.Service;

/**
 * 邮件认证策略
 *
 * @author Michelle.Chung
 */
@Slf4j
@Service("email" + IAuthStrategy.BASE_NAME)
@RequiredArgsConstructor
public class EmailAuthStrategy implements IAuthStrategy {

    private final SysLoginService loginService;
    private final SysUserMapper userMapper;

    @Override
    public LoginVo login(String body, SysClientVo client) {
        EmailLoginBody loginBody = JsonUtils.parseObject(body, EmailLoginBody.class);
        ValidatorUtils.validate(loginBody);
        String tenantId = loginBody.getTenantId();
        String email = loginBody.getEmail();
        String emailCode = loginBody.getEmailCode();
        LoginUser loginUser = TenantHelper.dynamic(tenantId, () -> {
            SysUserVo user = loadUserByEmail(email);
            loginService.checkLogin(LoginType.EMAIL, tenantId, user.getUserName(), () -> !validateEmailCode(tenantId, email, emailCode));
            // 此处可根据登录用户的数据不同 自行创建 loginUser 属性不够用继承扩展就行了
            return loginService.buildLoginUser(user);
        });
        loginUser.setClientKey(client.getClientKey());
        loginUser.setDeviceType(client.getDeviceType());
        SaLoginParameter model = new SaLoginParameter();
        model.setDeviceType(client.getDeviceType());
        // 自定义分配 不同用户体系 不同 token 授权时间 不设置默认走全局 yml 配置
        // 例如: 后台用户30分钟过期 app用户1天过期
        model.setTimeout(client.getTimeout());
        model.setActiveTimeout(client.getActiveTimeout());
        model.setExtra(LoginHelper.CLIENT_KEY, client.getClientId());
        // 生成token
        LoginHelper.login(loginUser, model);

        LoginVo loginVo = new LoginVo();
        loginVo.setAccessToken(StpUtil.getTokenValue());
        loginVo.setExpireIn(StpUtil.getTokenTimeout());
        loginVo.setClientId(client.getClientId());
        return loginVo;
    }

    /**
     * 校验邮箱验证码
     */
    private boolean validateEmailCode(String tenantId, String email, String emailCode) {
        String code = RedisUtils.getCacheObject(GlobalConstants.CAPTCHA_CODE_KEY + email);
        if (StringUtils.isBlank(code)) {
            loginService.recordLogininfor(tenantId, email, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire"));
            throw new CaptchaExpireException();
        }
        return code.equals(emailCode);
    }

    private SysUserVo loadUserByEmail(String email) {
        SysUserVo user = userMapper.selectVoOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getEmail, email));
        if (ObjectUtil.isNull(user)) {
            log.info("登录用户：{} 不存在.", email);
            throw new UserException("user.not.exists", email);
        } else if (SystemConstants.DISABLE.equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", email);
            throw new UserException("user.blocked", email);
        }
        return user;
    }

}
