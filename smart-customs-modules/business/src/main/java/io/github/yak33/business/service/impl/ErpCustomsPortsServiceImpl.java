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
import io.github.yak33.business.domain.bo.ErpCustomsPortsBo;
import io.github.yak33.business.domain.vo.ErpCustomsPortsVo;
import io.github.yak33.business.domain.ErpCustomsPorts;
import io.github.yak33.business.mapper.ErpCustomsPortsMapper;
import io.github.yak33.business.service.IErpCustomsPortsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 关区口岸Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-10-06
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ErpCustomsPortsServiceImpl implements IErpCustomsPortsService {

    private final ErpCustomsPortsMapper baseMapper;

    /**
     * 查询关区口岸
     *
     * @param id 主键
     * @return 关区口岸
     */
    @Override
    public ErpCustomsPortsVo queryById(String id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询关区口岸列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 关区口岸分页列表
     */
    @Override
    public TableDataInfo<ErpCustomsPortsVo> queryPageList(ErpCustomsPortsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ErpCustomsPorts> lqw = buildQueryWrapper(bo);
        Page<ErpCustomsPortsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的关区口岸列表
     *
     * @param bo 查询条件
     * @return 关区口岸列表
     */
    @Override
    public List<ErpCustomsPortsVo> queryList(ErpCustomsPortsBo bo) {
        LambdaQueryWrapper<ErpCustomsPorts> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ErpCustomsPorts> buildQueryWrapper(ErpCustomsPortsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ErpCustomsPorts> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(ErpCustomsPorts::getId);
        lqw.like(StringUtils.isNotBlank(bo.getCustomsPortCode()), ErpCustomsPorts::getCustomsPortCode, bo.getCustomsPortCode());
        lqw.like(StringUtils.isNotBlank(bo.getName()), ErpCustomsPorts::getName, bo.getName());
        lqw.like(StringUtils.isNotBlank(bo.getLangName()), ErpCustomsPorts::getLangName, bo.getLangName());
        return lqw;
    }

    /**
     * 新增关区口岸
     *
     * @param bo 关区口岸
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ErpCustomsPortsBo bo) {
        ErpCustomsPorts add = MapstructUtils.convert(bo, ErpCustomsPorts.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改关区口岸
     *
     * @param bo 关区口岸
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ErpCustomsPortsBo bo) {
        ErpCustomsPorts update = MapstructUtils.convert(bo, ErpCustomsPorts.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ErpCustomsPorts entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除关区口岸信息
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
