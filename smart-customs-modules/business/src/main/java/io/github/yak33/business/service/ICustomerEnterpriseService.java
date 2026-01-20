package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.CustomerEnterpriseVo;
import io.github.yak33.business.domain.bo.CustomerEnterpriseBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 企业海关备案信息Service接口
 *
 * @author ZHANGCHAO
 * @date 2026-01-20
 */
public interface ICustomerEnterpriseService {

    /**
     * 查询企业海关备案信息
     *
     * @param id 主键
     * @return 企业海关备案信息
     */
    CustomerEnterpriseVo queryById(String id);

    /**
     * 分页查询企业海关备案信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 企业海关备案信息分页列表
     */
    TableDataInfo<CustomerEnterpriseVo> queryPageList(CustomerEnterpriseBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的企业海关备案信息列表
     *
     * @param bo 查询条件
     * @return 企业海关备案信息列表
     */
    List<CustomerEnterpriseVo> queryList(CustomerEnterpriseBo bo);

    /**
     * 新增企业海关备案信息
     *
     * @param bo 企业海关备案信息
     * @return 是否新增成功
     */
    Boolean insertByBo(CustomerEnterpriseBo bo);

    /**
     * 修改企业海关备案信息
     *
     * @param bo 企业海关备案信息
     * @return 是否修改成功
     */
    Boolean updateByBo(CustomerEnterpriseBo bo);

    /**
     * 校验并批量删除企业海关备案信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
