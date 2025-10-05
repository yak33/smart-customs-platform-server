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
import io.github.yak33.business.domain.bo.ErpCurrenciesBo;
import io.github.yak33.business.domain.vo.ErpCurrenciesVo;
import io.github.yak33.business.domain.ErpCurrencies;
import io.github.yak33.business.mapper.ErpCurrenciesMapper;
import io.github.yak33.business.service.IErpCurrenciesService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 币制Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-06-28
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ErpCurrenciesServiceImpl implements IErpCurrenciesService {

    private final ErpCurrenciesMapper baseMapper;

    /**
     * 查询币制
     *
     * @param id 主键
     * @return 币制
     */
    @Override
    public ErpCurrenciesVo queryById(String id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询币制列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 币制分页列表
     */
    @Override
    public TableDataInfo<ErpCurrenciesVo> queryPageList(ErpCurrenciesBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ErpCurrencies> lqw = buildQueryWrapper(bo);
        Page<ErpCurrenciesVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的币制列表
     *
     * @param bo 查询条件
     * @return 币制列表
     */
    @Override
    public List<ErpCurrenciesVo> queryList(ErpCurrenciesBo bo) {
        LambdaQueryWrapper<ErpCurrencies> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ErpCurrencies> buildQueryWrapper(ErpCurrenciesBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ErpCurrencies> lqw = Wrappers.lambdaQuery();
        lqw.orderByDesc(ErpCurrencies::getCreateTime);
        lqw.eq(StringUtils.isNotBlank(bo.getCurrency()), ErpCurrencies::getCurrency, bo.getCurrency());
        lqw.like(StringUtils.isNotBlank(bo.getName()), ErpCurrencies::getName, bo.getName());
        lqw.like(StringUtils.isNotBlank(bo.getEnname()), ErpCurrencies::getEnname, bo.getEnname());
        lqw.eq(bo.getCurrencyOrder() != null, ErpCurrencies::getCurrencyOrder, bo.getCurrencyOrder());
        lqw.eq(StringUtils.isNotBlank(bo.getRate()), ErpCurrencies::getRate, bo.getRate());
        lqw.eq(bo.getThresholdLow() != null, ErpCurrencies::getThresholdLow, bo.getThresholdLow());
        lqw.eq(bo.getThresholdHigh() != null, ErpCurrencies::getThresholdHigh, bo.getThresholdHigh());
        return lqw;
    }

    /**
     * 新增币制
     *
     * @param bo 币制
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ErpCurrenciesBo bo) {
        ErpCurrencies add = MapstructUtils.convert(bo, ErpCurrencies.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改币制
     *
     * @param bo 币制
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ErpCurrenciesBo bo) {
        ErpCurrencies update = MapstructUtils.convert(bo, ErpCurrencies.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ErpCurrencies entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除币制信息
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
