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
import io.github.yak33.business.domain.bo.ErpChinaPortsBo;
import io.github.yak33.business.domain.vo.ErpChinaPortsVo;
import io.github.yak33.business.domain.ErpChinaPorts;
import io.github.yak33.business.mapper.ErpChinaPortsMapper;
import io.github.yak33.business.service.IErpChinaPortsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

import static cn.hutool.core.util.ObjectUtil.isEmpty;

/**
 * 口岸信息Service业务层处理
 *
 * @author ZHANGCHAO
 * @date 2025-06-21
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ErpChinaPortsServiceImpl implements IErpChinaPortsService {

    private final ErpChinaPortsMapper baseMapper;

    /**
     * 查询口岸信息
     *
     * @param id 主键
     * @return 口岸信息
     */
    @Override
    public ErpChinaPortsVo queryById(String id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询口岸信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 口岸信息分页列表
     */
    @Override
    public TableDataInfo<ErpChinaPortsVo> queryPageList(ErpChinaPortsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ErpChinaPorts> lqw = buildQueryWrapper(bo);
        Page<ErpChinaPortsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的口岸信息列表
     *
     * @param bo 查询条件
     * @return 口岸信息列表
     */
    @Override
    public List<ErpChinaPortsVo> queryList(ErpChinaPortsBo bo) {
        LambdaQueryWrapper<ErpChinaPorts> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ErpChinaPorts> buildQueryWrapper(ErpChinaPortsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ErpChinaPorts> lqw = Wrappers.lambdaQuery();
        lqw.orderByDesc(ErpChinaPorts::getCreateTime);
        lqw.like(StringUtils.isNotBlank(bo.getChinaPortCode()), ErpChinaPorts::getChinaPortCode, bo.getChinaPortCode());
        lqw.like(StringUtils.isNotBlank(bo.getName()), ErpChinaPorts::getName, bo.getName());
        lqw.like(StringUtils.isNotBlank(bo.getEnname()), ErpChinaPorts::getEnname, bo.getEnname());
        return lqw;
    }

    /**
     * 新增口岸信息
     *
     * @param bo 口岸信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ErpChinaPortsBo bo) {
        ErpChinaPorts add = MapstructUtils.convert(bo, ErpChinaPorts.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改口岸信息
     *
     * @param bo 口岸信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ErpChinaPortsBo bo) {
        ErpChinaPorts update = MapstructUtils.convert(bo, ErpChinaPorts.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ErpChinaPorts entity){
        //TODO 做一些数据校验,如唯一约束
        if (isEmpty(entity)) {
            throw new RuntimeException("数据不能为空！");
        }
    }

    /**
     * 校验并批量删除口岸信息信息
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
