package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.ErpCurrenciesVo;
import io.github.yak33.business.domain.bo.ErpCurrenciesBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 币制Service接口
 *
 * @author ZHANGCHAO
 * @date 2025-06-28
 */
public interface IErpCurrenciesService {

    /**
     * 查询币制
     *
     * @param id 主键
     * @return 币制
     */
    ErpCurrenciesVo queryById(String id);

    /**
     * 分页查询币制列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 币制分页列表
     */
    TableDataInfo<ErpCurrenciesVo> queryPageList(ErpCurrenciesBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的币制列表
     *
     * @param bo 查询条件
     * @return 币制列表
     */
    List<ErpCurrenciesVo> queryList(ErpCurrenciesBo bo);

    /**
     * 新增币制
     *
     * @param bo 币制
     * @return 是否新增成功
     */
    Boolean insertByBo(ErpCurrenciesBo bo);

    /**
     * 修改币制
     *
     * @param bo 币制
     * @return 是否修改成功
     */
    Boolean updateByBo(ErpCurrenciesBo bo);

    /**
     * 校验并批量删除币制信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
