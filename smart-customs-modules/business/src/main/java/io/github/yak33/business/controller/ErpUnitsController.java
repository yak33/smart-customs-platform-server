package io.github.yak33.business.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import io.github.yak33.common.idempotent.annotation.RepeatSubmit;
import io.github.yak33.common.log.annotation.Log;
import io.github.yak33.common.web.core.BaseController;
import io.github.yak33.common.mybatis.core.page.PageQuery;
import io.github.yak33.common.core.domain.R;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.yak33.common.log.enums.BusinessType;
import io.github.yak33.common.excel.utils.ExcelUtil;
import io.github.yak33.business.domain.vo.ErpUnitsVo;
import io.github.yak33.business.domain.bo.ErpUnitsBo;
import io.github.yak33.business.service.IErpUnitsService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 计量单位
 *
 * @author ZHANGCHAO
 * @date 2026-01-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/trade-compliance-library/units")
public class ErpUnitsController extends BaseController {

    private final IErpUnitsService erpUnitsService;

    /**
     * 查询计量单位列表
     */
    @SaCheckPermission("tradeComplianceLibrary:units:list")
    @GetMapping("/list")
    public TableDataInfo<ErpUnitsVo> list(ErpUnitsBo bo, PageQuery pageQuery) {
        return erpUnitsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出计量单位列表
     */
    @SaCheckPermission("tradeComplianceLibrary:units:export")
    @Log(title = "计量单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ErpUnitsBo bo, HttpServletResponse response) {
        List<ErpUnitsVo> list = erpUnitsService.queryList(bo);
        ExcelUtil.exportExcel(list, "计量单位", ErpUnitsVo.class, response);
    }

    /**
     * 获取计量单位详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("tradeComplianceLibrary:units:query")
    @GetMapping("/{id}")
    public R<ErpUnitsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(erpUnitsService.queryById(id));
    }

    /**
     * 新增计量单位
     */
    @SaCheckPermission("tradeComplianceLibrary:units:add")
    @Log(title = "计量单位", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ErpUnitsBo bo) {
        return toAjax(erpUnitsService.insertByBo(bo));
    }

    /**
     * 修改计量单位
     */
    @SaCheckPermission("tradeComplianceLibrary:units:edit")
    @Log(title = "计量单位", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ErpUnitsBo bo) {
        return toAjax(erpUnitsService.updateByBo(bo));
    }

    /**
     * 删除计量单位
     *
     * @param ids 主键串
     */
    @SaCheckPermission("tradeComplianceLibrary:units:remove")
    @Log(title = "计量单位", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        return toAjax(erpUnitsService.deleteWithValidByIds(List.of(ids), true));
    }
}
