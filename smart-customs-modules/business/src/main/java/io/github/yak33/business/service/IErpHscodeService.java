package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.ErpHscodeVo;
import io.github.yak33.business.domain.bo.ErpHscodeBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 海关编码申报税则相关Service接口
 *
 * @author ZHANGCHAO
 * @date 2025-09-08
 */
public interface IErpHscodeService {

    /**
     * 查询海关编码申报税则相关
     *
     * @param id 主键
     * @return 海关编码申报税则相关
     */
    ErpHscodeVo queryById(Long id);

    /**
     * 分页查询海关编码申报税则相关列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 海关编码申报税则相关分页列表
     */
    TableDataInfo<ErpHscodeVo> queryPageList(ErpHscodeBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的海关编码申报税则相关列表
     *
     * @param bo 查询条件
     * @return 海关编码申报税则相关列表
     */
    List<ErpHscodeVo> queryList(ErpHscodeBo bo);

    /**
     * 新增海关编码申报税则相关
     *
     * @param bo 海关编码申报税则相关
     * @return 是否新增成功
     */
    Boolean insertByBo(ErpHscodeBo bo);

    /**
     * 修改海关编码申报税则相关
     *
     * @param bo 海关编码申报税则相关
     * @return 是否修改成功
     */
    Boolean updateByBo(ErpHscodeBo bo);

    /**
     * 校验并批量删除海关编码申报税则相关信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
