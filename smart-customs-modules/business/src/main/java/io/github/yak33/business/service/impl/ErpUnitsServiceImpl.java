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
import io.github.yak33.business.domain.bo.ErpUnitsBo;
import io.github.yak33.business.domain.vo.ErpUnitsVo;
import io.github.yak33.business.domain.ErpUnits;
import io.github.yak33.business.mapper.ErpUnitsMapper;
import io.github.yak33.business.service.IErpUnitsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

import static cn.hutool.core.text.CharSequenceUtil.isNotBlank;

/**
 * 货物单位编码Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-10-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ErpUnitsServiceImpl implements IErpUnitsService {

    private final ErpUnitsMapper baseMapper;

    /**
     * 查询货物单位编码
     *
     * @param id 主键
     * @return 货物单位编码
     */
    @Override
    public ErpUnitsVo queryById(String id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询货物单位编码列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 货物单位编码分页列表
     */
    @Override
    public TableDataInfo<ErpUnitsVo> queryPageList(ErpUnitsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ErpUnits> lqw = buildQueryWrapper(bo);
        Page<ErpUnitsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的货物单位编码列表
     *
     * @param bo 查询条件
     * @return 货物单位编码列表
     */
    @Override
    public List<ErpUnitsVo> queryList(ErpUnitsBo bo) {
        LambdaQueryWrapper<ErpUnits> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ErpUnits> buildQueryWrapper(ErpUnitsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ErpUnits> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(ErpUnits::getId);
        lqw.eq(isNotBlank(bo.getCode()), ErpUnits::getCode, bo.getCode());
        lqw.like(isNotBlank(bo.getName()), ErpUnits::getName, bo.getName());
        lqw.eq(isNotBlank(bo.getItemKey()), ErpUnits::getItemKey, bo.getItemKey());
        lqw.like(isNotBlank(bo.getEnname()), ErpUnits::getEnname, bo.getEnname());
        return lqw;
    }

    /**
     * 新增货物单位编码
     *
     * @param bo 货物单位编码
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ErpUnitsBo bo) {
        ErpUnits add = MapstructUtils.convert(bo, ErpUnits.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改货物单位编码
     *
     * @param bo 货物单位编码
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ErpUnitsBo bo) {
        ErpUnits update = MapstructUtils.convert(bo, ErpUnits.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ErpUnits entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除货物单位编码信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
