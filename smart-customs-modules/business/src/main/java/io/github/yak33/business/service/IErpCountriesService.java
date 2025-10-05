package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.ErpCountriesVo;
import io.github.yak33.business.domain.bo.ErpCountriesBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 国家Service接口
 *
 * @author ZHANGCHAO
 * @date 2025-06-29
 */
public interface IErpCountriesService {

    /**
     * 查询国家
     *
     * @param id 主键
     * @return 国家
     */
    ErpCountriesVo queryById(String id);

    /**
     * 分页查询国家列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 国家分页列表
     */
    TableDataInfo<ErpCountriesVo> queryPageList(ErpCountriesBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的国家列表
     *
     * @param bo 查询条件
     * @return 国家列表
     */
    List<ErpCountriesVo> queryList(ErpCountriesBo bo);

    /**
     * 新增国家
     *
     * @param bo 国家
     * @return 是否新增成功
     */
    Boolean insertByBo(ErpCountriesBo bo);

    /**
     * 修改国家
     *
     * @param bo 国家
     * @return 是否修改成功
     */
    Boolean updateByBo(ErpCountriesBo bo);

    /**
     * 校验并批量删除国家信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
