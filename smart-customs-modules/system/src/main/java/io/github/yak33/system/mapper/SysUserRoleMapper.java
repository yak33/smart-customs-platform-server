package io.github.yak33.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.yak33.common.mybatis.core.mapper.BaseMapperPlus;
import io.github.yak33.system.domain.SysUserRole;

import java.util.List;

/**
 * 用户与角色关联表 数据层
 *
 * @author ZHANGCHAO
 */
public interface SysUserRoleMapper extends BaseMapperPlus<SysUserRole, SysUserRole> {

    /**
     * 根据角色ID查询关联的用户ID列表
     *
     * @param roleId 角色ID
     * @return 关联到指定角色的用户ID列表
     */
    default List<Long> selectUserIdsByRoleId(Long roleId) {
        return this.selectObjs(new LambdaQueryWrapper<SysUserRole>()
            .select(SysUserRole::getUserId).eq(SysUserRole::getRoleId, roleId)
        );
    }

}
