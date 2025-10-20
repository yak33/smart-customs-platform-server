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
import io.github.yak33.business.domain.bo.GoodsPnBo;
import io.github.yak33.business.domain.vo.GoodsPnVo;
import io.github.yak33.business.domain.GoodsPn;
import io.github.yak33.business.mapper.GoodsPnMapper;
import io.github.yak33.business.service.IGoodsPnService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

import static cn.hutool.core.text.CharSequenceUtil.isNotBlank;

/**
 * 商品库Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-10-20
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class GoodsPnServiceImpl implements IGoodsPnService {

    private final GoodsPnMapper baseMapper;

    /**
     * 查询商品库
     *
     * @param id 主键
     * @return 商品库
     */
    @Override
    public GoodsPnVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询商品库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 商品库分页列表
     */
    @Override
    public TableDataInfo<GoodsPnVo> queryPageList(GoodsPnBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<GoodsPn> lqw = buildQueryWrapper(bo);
        Page<GoodsPnVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的商品库列表
     *
     * @param bo 查询条件
     * @return 商品库列表
     */
    @Override
    public List<GoodsPnVo> queryList(GoodsPnBo bo) {
        LambdaQueryWrapper<GoodsPn> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<GoodsPn> buildQueryWrapper(GoodsPnBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<GoodsPn> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(GoodsPn::getId);
        lqw.eq(bo.getOwnerId() != null, GoodsPn::getOwnerId, bo.getOwnerId());
        lqw.eq(isNotBlank(bo.getPartNumber()), GoodsPn::getPartNumber, bo.getPartNumber());
        lqw.eq(isNotBlank(bo.getCustomerNo()), GoodsPn::getCustomerNo, bo.getCustomerNo());
        lqw.eq(isNotBlank(bo.getAdditionalCode()), GoodsPn::getAdditionalCode, bo.getAdditionalCode());
        lqw.like(isNotBlank(bo.getHsname()), GoodsPn::getHsname, bo.getHsname());
        lqw.like(isNotBlank(bo.getHscode()), GoodsPn::getHscode, bo.getHscode());
        lqw.like(isNotBlank(bo.getHsmodel()), GoodsPn::getHsmodel, bo.getHsmodel());
        lqw.eq(isNotBlank(bo.getCiqCode()), GoodsPn::getCiqCode, bo.getCiqCode());
        lqw.like(isNotBlank(bo.getCiqName()), GoodsPn::getCiqName, bo.getCiqName());
        lqw.eq(isNotBlank(bo.getHsmemo()), GoodsPn::getHsmemo, bo.getHsmemo());
        lqw.like(isNotBlank(bo.getModel()), GoodsPn::getModel, bo.getModel());
        lqw.like(isNotBlank(bo.getName()), GoodsPn::getName, bo.getName());
        lqw.like(isNotBlank(bo.getEnName()), GoodsPn::getEnName, bo.getEnName());
        lqw.like(isNotBlank(bo.getEnMemo()), GoodsPn::getEnMemo, bo.getEnMemo());
        lqw.like(isNotBlank(bo.getCnMemo()), GoodsPn::getCnMemo, bo.getCnMemo());
        lqw.eq(isNotBlank(bo.getUn()), GoodsPn::getUn, bo.getUn());
        lqw.eq(isNotBlank(bo.getChemicalsNo()), GoodsPn::getChemicalsNo, bo.getChemicalsNo());
        lqw.eq(isNotBlank(bo.getCountry()), GoodsPn::getCountry, bo.getCountry());
        lqw.eq(bo.getCustomerConfirm() != null, GoodsPn::getCustomerConfirm, bo.getCustomerConfirm());
        lqw.eq(bo.getIsAudited() != null, GoodsPn::getIsAudited, bo.getIsAudited());
        lqw.eq(bo.getIsChecked() != null, GoodsPn::getIsChecked, bo.getIsChecked());
        lqw.eq(isNotBlank(bo.getAttachments()), GoodsPn::getAttachments, bo.getAttachments());
        lqw.eq(isNotBlank(bo.getPartType()), GoodsPn::getPartType, bo.getPartType());
        lqw.eq(bo.getPartStatus() != null, GoodsPn::getPartStatus, bo.getPartStatus());
        lqw.eq(isNotBlank(bo.getUpdateRemark()), GoodsPn::getUpdateRemark, bo.getUpdateRemark());
        lqw.eq(bo.getCreateDate() != null, GoodsPn::getCreateDate, bo.getCreateDate());
        lqw.eq(isNotBlank(bo.getLastUpdateBy()), GoodsPn::getLastUpdateBy, bo.getLastUpdateBy());
        lqw.eq(bo.getLastUpdateDate() != null, GoodsPn::getLastUpdateDate, bo.getLastUpdateDate());
        return lqw;
    }

    /**
     * 新增商品库
     *
     * @param bo 商品库
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(GoodsPnBo bo) {
        GoodsPn add = MapstructUtils.convert(bo, GoodsPn.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改商品库
     *
     * @param bo 商品库
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(GoodsPnBo bo) {
        GoodsPn update = MapstructUtils.convert(bo, GoodsPn.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(GoodsPn entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除商品库信息
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
