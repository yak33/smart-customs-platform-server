package io.github.yak33.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.github.yak33.common.core.domain.R;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.yak33.common.core.validate.QueryGroup;
import io.github.yak33.common.web.core.BaseController;
import io.github.yak33.common.idempotent.annotation.RepeatSubmit;
import io.github.yak33.common.log.annotation.Log;
import io.github.yak33.common.log.enums.BusinessType;
import io.github.yak33.common.mybatis.core.page.PageQuery;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;
import io.github.yak33.system.domain.bo.SysOssConfigBo;
import io.github.yak33.system.domain.vo.SysOssConfigVo;
import io.github.yak33.system.service.ISysOssConfigService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 对象存储配置
 *
 * @author ZHANGCHAO
 * @author 孤舟烟雨
 * @date 2021-08-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/resource/oss/config")
public class SysOssConfigController extends BaseController {

    private final ISysOssConfigService ossConfigService;

    /**
     * 查询对象存储配置列表
     */
    @SaCheckPermission("system:ossConfig:list")
    @GetMapping("/list")
    public TableDataInfo<SysOssConfigVo> list(@Validated(QueryGroup.class) SysOssConfigBo bo, PageQuery pageQuery) {
        return ossConfigService.queryPageList(bo, pageQuery);
    }

    /**
     * 获取对象存储配置详细信息
     *
     * @param ossConfigId OSS配置ID
     */
    @SaCheckPermission("system:ossConfig:list")
    @GetMapping("/{ossConfigId}")
    public R<SysOssConfigVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long ossConfigId) {
        return R.ok(ossConfigService.queryById(ossConfigId));
    }

    /**
     * 新增对象存储配置
     */
    @SaCheckPermission("system:ossConfig:add")
    @Log(title = "对象存储配置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody SysOssConfigBo bo) {
        return toAjax(ossConfigService.insertByBo(bo));
    }

    /**
     * 修改对象存储配置
     */
    @SaCheckPermission("system:ossConfig:edit")
    @Log(title = "对象存储配置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody SysOssConfigBo bo) {
        return toAjax(ossConfigService.updateByBo(bo));
    }

    /**
     * 删除对象存储配置
     *
     * @param ossConfigIds OSS配置ID串
     */
    @SaCheckPermission("system:ossConfig:remove")
    @Log(title = "对象存储配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ossConfigIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ossConfigIds) {
        return toAjax(ossConfigService.deleteWithValidByIds(List.of(ossConfigIds), true));
    }

    /**
     * 状态修改
     */
    @SaCheckPermission("system:ossConfig:edit")
    @Log(title = "对象存储状态修改", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/changeStatus")
    public R<Void> changeStatus(@RequestBody SysOssConfigBo bo) {
        return toAjax(ossConfigService.updateOssConfigStatus(bo));
    }
}
