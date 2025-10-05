package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.ErpChinaPortsVo;
import io.github.yak33.business.domain.bo.ErpChinaPortsBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 口岸信息Service接口
 *
 * @author ZHANGCHAO
 * @date 2025-06-21
 */
public interface IErpChinaPortsService {

    /**
     * 查询口岸信息
     *
     * @param id 主键
     * @return 口岸信息
     */
    ErpChinaPortsVo queryById(String id);

    /**
     * 分页查询口岸信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 口岸信息分页列表
     */
    TableDataInfo<ErpChinaPortsVo> queryPageList(ErpChinaPortsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的口岸信息列表
     *
     * @param bo 查询条件
     * @return 口岸信息列表
     */
    List<ErpChinaPortsVo> queryList(ErpChinaPortsBo bo);

    /**
     * 新增口岸信息
     *
     * @param bo 口岸信息
     * @return 是否新增成功
     */
    Boolean insertByBo(ErpChinaPortsBo bo);

    /**
     * 修改口岸信息
     *
     * @param bo 口岸信息
     * @return 是否修改成功
     */
    Boolean updateByBo(ErpChinaPortsBo bo);

    /**
     * 校验并批量删除口岸信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
