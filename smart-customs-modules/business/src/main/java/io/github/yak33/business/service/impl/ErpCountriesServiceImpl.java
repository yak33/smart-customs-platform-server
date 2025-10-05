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
import io.github.yak33.business.domain.bo.ErpCountriesBo;
import io.github.yak33.business.domain.vo.ErpCountriesVo;
import io.github.yak33.business.domain.ErpCountries;
import io.github.yak33.business.mapper.ErpCountriesMapper;
import io.github.yak33.business.service.IErpCountriesService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 国家Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-06-29
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ErpCountriesServiceImpl implements IErpCountriesService {

    private final ErpCountriesMapper baseMapper;

    /**
     * 查询国家
     *
     * @param id 主键
     * @return 国家
     */
    @Override
    public ErpCountriesVo queryById(String id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询国家列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 国家分页列表
     */
    @Override
    public TableDataInfo<ErpCountriesVo> queryPageList(ErpCountriesBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ErpCountries> lqw = buildQueryWrapper(bo);
        Page<ErpCountriesVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的国家列表
     *
     * @param bo 查询条件
     * @return 国家列表
     */
    @Override
    public List<ErpCountriesVo> queryList(ErpCountriesBo bo) {
        LambdaQueryWrapper<ErpCountries> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ErpCountries> buildQueryWrapper(ErpCountriesBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ErpCountries> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getCode()), ErpCountries::getCode, bo.getCode());
        lqw.like(StringUtils.isNotBlank(bo.getName()), ErpCountries::getName, bo.getName());
        lqw.like(StringUtils.isNotBlank(bo.getStandardCode()), ErpCountries::getStandardCode, bo.getStandardCode());
        lqw.like(StringUtils.isNotBlank(bo.getEnname()), ErpCountries::getEnname, bo.getEnname());
        lqw.orderByDesc(ErpCountries::getCreateTime);
        return lqw;
    }

    /**
     * 新增国家
     *
     * @param bo 国家
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ErpCountriesBo bo) {
        ErpCountries add = MapstructUtils.convert(bo, ErpCountries.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改国家
     *
     * @param bo 国家
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ErpCountriesBo bo) {
        ErpCountries update = MapstructUtils.convert(bo, ErpCountries.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ErpCountries entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除国家信息
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
