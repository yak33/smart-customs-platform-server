package io.github.yak33.business.service;

import io.github.yak33.business.domain.vo.GoodsPnVo;
import io.github.yak33.business.domain.bo.GoodsPnBo;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 商品库Service接口
 *
 * @author ZHANGCHAO
 * @date 2025-10-20
 */
public interface IGoodsPnService {

    /**
     * 查询商品库
     *
     * @param id 主键
     * @return 商品库
     */
    GoodsPnVo queryById(Long id);

    /**
     * 分页查询商品库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 商品库分页列表
     */
    TableDataInfo<GoodsPnVo> queryPageList(GoodsPnBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的商品库列表
     *
     * @param bo 查询条件
     * @return 商品库列表
     */
    List<GoodsPnVo> queryList(GoodsPnBo bo);

    /**
     * 新增商品库
     *
     * @param bo 商品库
     * @return 是否新增成功
     */
    Boolean insertByBo(GoodsPnBo bo);

    /**
     * 修改商品库
     *
     * @param bo 商品库
     * @return 是否修改成功
     */
    Boolean updateByBo(GoodsPnBo bo);

    /**
     * 校验并批量删除商品库信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
