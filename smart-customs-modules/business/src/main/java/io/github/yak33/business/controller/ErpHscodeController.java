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
import io.github.yak33.business.domain.vo.ErpHscodeVo;
import io.github.yak33.business.domain.bo.ErpHscodeBo;
import io.github.yak33.business.service.IErpHscodeService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 海关编码申报税则相关
 *
 * @author ZHANGCHAO
 * @date 2025-09-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/hscode")
public class ErpHscodeController extends BaseController {

    private final IErpHscodeService erpHscodeService;

    /**
     * 查询海关编码申报税则相关列表
     */
    @SaCheckPermission("business:hscode:list")
    @GetMapping("/list")
    public TableDataInfo<ErpHscodeVo> list(ErpHscodeBo bo, PageQuery pageQuery) {
        return erpHscodeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出海关编码申报税则相关列表
     */
    @SaCheckPermission("business:hscode:export")
    @Log(title = "海关编码申报税则相关", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ErpHscodeBo bo, HttpServletResponse response) {
        List<ErpHscodeVo> list = erpHscodeService.queryList(bo);
        ExcelUtil.exportExcel(list, "海关编码申报税则相关", ErpHscodeVo.class, response);
    }

    /**
     * 获取海关编码申报税则相关详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:hscode:query")
    @GetMapping("/{id}")
    public R<ErpHscodeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(erpHscodeService.queryById(id));
    }

    /**
     * 新增海关编码申报税则相关
     */
    @SaCheckPermission("business:hscode:add")
    @Log(title = "海关编码申报税则相关", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ErpHscodeBo bo) {
        return toAjax(erpHscodeService.insertByBo(bo));
    }

    /**
     * 修改海关编码申报税则相关
     */
    @SaCheckPermission("business:hscode:edit")
    @Log(title = "海关编码申报税则相关", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ErpHscodeBo bo) {
        return toAjax(erpHscodeService.updateByBo(bo));
    }

    /**
     * 删除海关编码申报税则相关
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:hscode:remove")
    @Log(title = "海关编码申报税则相关", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(erpHscodeService.deleteWithValidByIds(List.of(ids), true));
    }
}
