package io.github.yak33.business.service.impl;

import io.github.yak33.common.core.utils.MapstructUtils;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.github.yak33.business.domain.bo.CustomerEnterpriseBo;
import io.github.yak33.business.domain.vo.CustomerEnterpriseVo;
import io.github.yak33.business.domain.CustomerEnterprise;
import io.github.yak33.business.mapper.CustomerEnterpriseMapper;
import io.github.yak33.business.service.ICustomerEnterpriseService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

import static cn.hutool.core.text.CharSequenceUtil.isNotBlank;

/**
 * 企业海关备案信息库Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-10-19
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerEnterpriseServiceImpl implements ICustomerEnterpriseService {

    private final CustomerEnterpriseMapper baseMapper;

    /**
     * 查询企业海关备案信息库
     *
     * @param id 主键
     * @return 企业海关备案信息库
     */
    @Override
    public CustomerEnterpriseVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询企业海关备案信息库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 企业海关备案信息库分页列表
     */
    @Override
    public TableDataInfo<CustomerEnterpriseVo> queryPageList(CustomerEnterpriseBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CustomerEnterprise> lqw = buildQueryWrapper(bo);
        Page<CustomerEnterpriseVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的企业海关备案信息库列表
     *
     * @param bo 查询条件
     * @return 企业海关备案信息库列表
     */
    @Override
    public List<CustomerEnterpriseVo> queryList(CustomerEnterpriseBo bo) {
        LambdaQueryWrapper<CustomerEnterprise> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CustomerEnterprise> buildQueryWrapper(CustomerEnterpriseBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CustomerEnterprise> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CustomerEnterprise::getId);
        lqw.like(isNotBlank(bo.getDepartName()), CustomerEnterprise::getDepartName, bo.getDepartName());
        lqw.like(isNotBlank(bo.getSocialCode()), CustomerEnterprise::getSocialCode, bo.getSocialCode());
        lqw.like(isNotBlank(bo.getDepartcd()), CustomerEnterprise::getDepartcd, bo.getDepartcd());
        lqw.like(isNotBlank(bo.getCiqCode()), CustomerEnterprise::getCiqCode, bo.getCiqCode());
        lqw.like(isNotBlank(bo.getAeo()), CustomerEnterprise::getAeo, bo.getAeo());
        lqw.eq(isNotBlank(bo.getCreditRating()), CustomerEnterprise::getCreditRating, bo.getCreditRating());
        lqw.eq(isNotBlank(bo.getTrrmOfValidity()), CustomerEnterprise::getTrrmOfValidity, bo.getTrrmOfValidity());
        lqw.eq(isNotBlank(bo.getCancellation()), CustomerEnterprise::getCancellation, bo.getCancellation());
        lqw.eq(isNotBlank(bo.getManageType()), CustomerEnterprise::getManageType, bo.getManageType());
        lqw.eq(isNotBlank(bo.getType()), CustomerEnterprise::getType, bo.getType());
        return lqw;
    }

    /**
     * 新增企业海关备案信息库
     *
     * @param bo 企业海关备案信息库
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CustomerEnterpriseBo bo) {
        CustomerEnterprise add = MapstructUtils.convert(bo, CustomerEnterprise.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改企业海关备案信息库
     *
     * @param bo 企业海关备案信息库
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CustomerEnterpriseBo bo) {
        CustomerEnterprise update = MapstructUtils.convert(bo, CustomerEnterprise.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CustomerEnterprise entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除企业海关备案信息库信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
