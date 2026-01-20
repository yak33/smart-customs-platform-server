package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.ErpUnitsVo;
import io.github.yak33.business.domain.bo.ErpUnitsBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 计量单位Service接口
 *
 * @author ZHANGCHAO
 * @date 2026-01-19
 */
public interface IErpUnitsService {

    /**
     * 查询计量单位
     *
     * @param id 主键
     * @return 计量单位
     */
    ErpUnitsVo queryById(String id);

    /**
     * 分页查询计量单位列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 计量单位分页列表
     */
    TableDataInfo<ErpUnitsVo> queryPageList(ErpUnitsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的计量单位列表
     *
     * @param bo 查询条件
     * @return 计量单位列表
     */
    List<ErpUnitsVo> queryList(ErpUnitsBo bo);

    /**
     * 新增计量单位
     *
     * @param bo 计量单位
     * @return 是否新增成功
     */
    Boolean insertByBo(ErpUnitsBo bo);

    /**
     * 修改计量单位
     *
     * @param bo 计量单位
     * @return 是否修改成功
     */
    Boolean updateByBo(ErpUnitsBo bo);

    /**
     * 校验并批量删除计量单位信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
