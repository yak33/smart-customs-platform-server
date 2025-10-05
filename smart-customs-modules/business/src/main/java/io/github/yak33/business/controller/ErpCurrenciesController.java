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
import io.github.yak33.business.domain.vo.ErpCurrenciesVo;
import io.github.yak33.business.domain.bo.ErpCurrenciesBo;
import io.github.yak33.business.service.IErpCurrenciesService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 币制
 *
 * @author ZHANGCHAO
 * @date 2025-06-28
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/currencies")
public class ErpCurrenciesController extends BaseController {

    private final IErpCurrenciesService erpCurrenciesService;

    /**
     * 查询币制列表
     */
    @SaCheckPermission("business:currencies:list")
    @GetMapping("/list")
    public TableDataInfo<ErpCurrenciesVo> list(ErpCurrenciesBo bo, PageQuery pageQuery) {
        return erpCurrenciesService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出币制列表
     */
    @SaCheckPermission("business:currencies:export")
    @Log(title = "币制", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ErpCurrenciesBo bo, HttpServletResponse response) {
        List<ErpCurrenciesVo> list = erpCurrenciesService.queryList(bo);
        ExcelUtil.exportExcel(list, "币制", ErpCurrenciesVo.class, response);
    }

    /**
     * 获取币制详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:currencies:query")
    @GetMapping("/{id}")
    public R<ErpCurrenciesVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(erpCurrenciesService.queryById(id));
    }

    /**
     * 新增币制
     */
    @SaCheckPermission("business:currencies:add")
    @Log(title = "币制", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ErpCurrenciesBo bo) {
        return toAjax(erpCurrenciesService.insertByBo(bo));
    }

    /**
     * 修改币制
     */
    @SaCheckPermission("business:currencies:edit")
    @Log(title = "币制", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ErpCurrenciesBo bo) {
        return toAjax(erpCurrenciesService.updateByBo(bo));
    }

    /**
     * 删除币制
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:currencies:remove")
    @Log(title = "币制", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        return toAjax(erpCurrenciesService.deleteWithValidByIds(List.of(ids), true));
    }
}
