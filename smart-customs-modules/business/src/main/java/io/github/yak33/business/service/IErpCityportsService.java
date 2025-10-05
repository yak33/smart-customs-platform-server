package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.ErpCityportsVo;
import io.github.yak33.business.domain.bo.ErpCityportsBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 港口Service接口
 *
 * @author ZHANGCHAO
 * @date 2025-06-23
 */
public interface IErpCityportsService {

    /**
     * 查询港口
     *
     * @param id 主键
     * @return 港口
     */
    ErpCityportsVo queryById(String id);

    /**
     * 分页查询港口列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 港口分页列表
     */
    TableDataInfo<ErpCityportsVo> queryPageList(ErpCityportsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的港口列表
     *
     * @param bo 查询条件
     * @return 港口列表
     */
    List<ErpCityportsVo> queryList(ErpCityportsBo bo);

    /**
     * 新增港口
     *
     * @param bo 港口
     * @return 是否新增成功
     */
    Boolean insertByBo(ErpCityportsBo bo);

    /**
     * 修改港口
     *
     * @param bo 港口
     * @return 是否修改成功
     */
    Boolean updateByBo(ErpCityportsBo bo);

    /**
     * 校验并批量删除港口信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
