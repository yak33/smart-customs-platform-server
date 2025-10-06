package io.github.yak33.business.service.impl;

import io.github.yak33.common.core.utils.MapstructUtils;
import io.github.yak33.common.core.utils.StringUtils;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.github.yak33.business.domain.bo.ErpHscodeBo;
import io.github.yak33.business.domain.vo.ErpHscodeVo;
import io.github.yak33.business.domain.ErpHscode;
import io.github.yak33.business.mapper.ErpHscodeMapper;
import io.github.yak33.business.service.IErpHscodeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 海关编码申报税则相关Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-09-08
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ErpHscodeServiceImpl implements IErpHscodeService {

    private final ErpHscodeMapper baseMapper;

    /**
     * 查询海关编码申报税则相关
     *
     * @param id 主键
     * @return 海关编码申报税则相关
     */
    @Override
    public ErpHscodeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询海关编码申报税则相关列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 海关编码申报税则相关分页列表
     */
    @Override
    public TableDataInfo<ErpHscodeVo> queryPageList(ErpHscodeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ErpHscode> lqw = buildQueryWrapper(bo);
        Page<ErpHscodeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的海关编码申报税则相关列表
     *
     * @param bo 查询条件
     * @return 海关编码申报税则相关列表
     */
    @Override
    public List<ErpHscodeVo> queryList(ErpHscodeBo bo) {
        LambdaQueryWrapper<ErpHscode> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ErpHscode> buildQueryWrapper(ErpHscodeBo bo) {
        LambdaQueryWrapper<ErpHscode> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(ErpHscode::getId);
        lqw.like(StringUtils.isNotBlank(bo.getHscode()), ErpHscode::getHscode, bo.getHscode());
        lqw.like(StringUtils.isNotBlank(bo.getGname()), ErpHscode::getGname, bo.getGname());
        lqw.like(StringUtils.isNotBlank(bo.getControLmark()), ErpHscode::getControLmark, bo.getControLmark());
        lqw.like(StringUtils.isNotBlank(bo.getUnit1()), ErpHscode::getUnit1, bo.getUnit1());
        lqw.like(StringUtils.isNotBlank(bo.getUnit1name()), ErpHscode::getUnit1name, bo.getUnit1name());
        lqw.like(StringUtils.isNotBlank(bo.getUnit2()), ErpHscode::getUnit2, bo.getUnit2());
        lqw.like(StringUtils.isNotBlank(bo.getUnit2name()), ErpHscode::getUnit2name, bo.getUnit2name());
        lqw.like(StringUtils.isNotBlank(bo.getInspmonitorcond()), ErpHscode::getInspmonitorcond, bo.getInspmonitorcond());
        lqw.like(StringUtils.isNotBlank(bo.getNotes()), ErpHscode::getNotes, bo.getNotes());
        lqw.like(StringUtils.isNotBlank(bo.getSbys()), ErpHscode::getSbys, bo.getSbys());
        lqw.like(StringUtils.isNotBlank(bo.getCiqlist()), ErpHscode::getCiqlist, bo.getCiqlist());
        lqw.like(StringUtils.isNotBlank(bo.getCiqclass()), ErpHscode::getCiqclass, bo.getCiqclass());
        lqw.like(StringUtils.isNotBlank(bo.getSbysRequired()), ErpHscode::getSbysRequired, bo.getSbysRequired());
        lqw.eq(bo.getIsEnable() != null, ErpHscode::getIsEnable, bo.getIsEnable());
        return lqw;
    }

    /**
     * 新增海关编码申报税则相关
     *
     * @param bo 海关编码申报税则相关
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ErpHscodeBo bo) {
        ErpHscode add = MapstructUtils.convert(bo, ErpHscode.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改海关编码申报税则相关
     *
     * @param bo 海关编码申报税则相关
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ErpHscodeBo bo) {
        ErpHscode update = MapstructUtils.convert(bo, ErpHscode.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ErpHscode entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除海关编码申报税则相关信息
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
