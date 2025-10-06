package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.ErpCustomsPortsVo;
import io.github.yak33.business.domain.bo.ErpCustomsPortsBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 关区口岸Service接口
 *
 * @author ZHANGCHAO
 * @date 2025-10-06
 */
public interface IErpCustomsPortsService {

    /**
     * 查询关区口岸
     *
     * @param id 主键
     * @return 关区口岸
     */
    ErpCustomsPortsVo queryById(String id);

    /**
     * 分页查询关区口岸列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 关区口岸分页列表
     */
    TableDataInfo<ErpCustomsPortsVo> queryPageList(ErpCustomsPortsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的关区口岸列表
     *
     * @param bo 查询条件
     * @return 关区口岸列表
     */
    List<ErpCustomsPortsVo> queryList(ErpCustomsPortsBo bo);

    /**
     * 新增关区口岸
     *
     * @param bo 关区口岸
     * @return 是否新增成功
     */
    Boolean insertByBo(ErpCustomsPortsBo bo);

    /**
     * 修改关区口岸
     *
     * @param bo 关区口岸
     * @return 是否修改成功
     */
    Boolean updateByBo(ErpCustomsPortsBo bo);

    /**
     * 校验并批量删除关区口岸信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid);
}
