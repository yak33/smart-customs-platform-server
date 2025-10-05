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
import io.github.yak33.business.domain.bo.ErpCityportsBo;
import io.github.yak33.business.domain.vo.ErpCityportsVo;
import io.github.yak33.business.domain.ErpCityports;
import io.github.yak33.business.mapper.ErpCityportsMapper;
import io.github.yak33.business.service.IErpCityportsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 港口Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-06-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ErpCityportsServiceImpl implements IErpCityportsService {

    private final ErpCityportsMapper baseMapper;

    /**
     * 查询港口
     *
     * @param id 主键
     * @return 港口
     */
    @Override
    public ErpCityportsVo queryById(String id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询港口列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 港口分页列表
     */
    @Override
    public TableDataInfo<ErpCityportsVo> queryPageList(ErpCityportsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ErpCityports> lqw = buildQueryWrapper(bo);
        Page<ErpCityportsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的港口列表
     *
     * @param bo 查询条件
     * @return 港口列表
     */
    @Override
    public List<ErpCityportsVo> queryList(ErpCityportsBo bo) {
        LambdaQueryWrapper<ErpCityports> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ErpCityports> buildQueryWrapper(ErpCityportsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ErpCityports> lqw = Wrappers.lambdaQuery();
        lqw.orderByDesc(ErpCityports::getCreateTime);
        lqw.like(StringUtils.isNotBlank(bo.getCityportCode()), ErpCityports::getCityportCode, bo.getCityportCode());
        lqw.like(StringUtils.isNotBlank(bo.getCnname()), ErpCityports::getCnname, bo.getCnname());
        lqw.like(StringUtils.isNotBlank(bo.getEnname()), ErpCityports::getEnname, bo.getEnname());
        return lqw;
    }

    /**
     * 新增港口
     *
     * @param bo 港口
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ErpCityportsBo bo) {
        ErpCityports add = MapstructUtils.convert(bo, ErpCityports.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改港口
     *
     * @param bo 港口
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ErpCityportsBo bo) {
        ErpCityports update = MapstructUtils.convert(bo, ErpCityports.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ErpCityports entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除港口信息
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
