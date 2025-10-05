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
import io.github.yak33.business.domain.vo.ErpCityportsVo;
import io.github.yak33.business.domain.bo.ErpCityportsBo;
import io.github.yak33.business.service.IErpCityportsService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 港口
 *
 * @author ZHANGCHAO
 * @date 2025-06-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/cityports")
public class ErpCityportsController extends BaseController {

    private final IErpCityportsService erpCityportsService;

    /**
     * 查询港口列表
     */
    @SaCheckPermission("business:cityports:list")
    @GetMapping("/list")
    public TableDataInfo<ErpCityportsVo> list(ErpCityportsBo bo, PageQuery pageQuery) {
        return erpCityportsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出港口列表
     */
    @SaCheckPermission("business:cityports:export")
    @Log(title = "港口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ErpCityportsBo bo, HttpServletResponse response) {
        List<ErpCityportsVo> list = erpCityportsService.queryList(bo);
        ExcelUtil.exportExcel(list, "港口", ErpCityportsVo.class, response);
    }

    /**
     * 获取港口详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:cityports:query")
    @GetMapping("/{id}")
    public R<ErpCityportsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(erpCityportsService.queryById(id));
    }

    /**
     * 新增港口
     */
    @SaCheckPermission("business:cityports:add")
    @Log(title = "港口", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ErpCityportsBo bo) {
        return toAjax(erpCityportsService.insertByBo(bo));
    }

    /**
     * 修改港口
     */
    @SaCheckPermission("business:cityports:edit")
    @Log(title = "港口", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ErpCityportsBo bo) {
        return toAjax(erpCityportsService.updateByBo(bo));
    }

    /**
     * 删除港口
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:cityports:remove")
    @Log(title = "港口", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        return toAjax(erpCityportsService.deleteWithValidByIds(List.of(ids), true));
    }
}
