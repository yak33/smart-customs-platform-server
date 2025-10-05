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
import io.github.yak33.business.domain.vo.ErpCountriesVo;
import io.github.yak33.business.domain.bo.ErpCountriesBo;
import io.github.yak33.business.service.IErpCountriesService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 国家
 *
 * @author ZHANGCHAO
 * @date 2025-06-29
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/countries")
public class ErpCountriesController extends BaseController {

    private final IErpCountriesService erpCountriesService;

    /**
     * 查询国家列表
     */
    @SaCheckPermission("business:countries:list")
    @GetMapping("/list")
    public TableDataInfo<ErpCountriesVo> list(ErpCountriesBo bo, PageQuery pageQuery) {
        return erpCountriesService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出国家列表
     */
    @SaCheckPermission("business:countries:export")
    @Log(title = "国家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ErpCountriesBo bo, HttpServletResponse response) {
        List<ErpCountriesVo> list = erpCountriesService.queryList(bo);
        ExcelUtil.exportExcel(list, "国家", ErpCountriesVo.class, response);
    }

    /**
     * 获取国家详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:countries:query")
    @GetMapping("/{id}")
    public R<ErpCountriesVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(erpCountriesService.queryById(id));
    }

    /**
     * 新增国家
     */
    @SaCheckPermission("business:countries:add")
    @Log(title = "国家", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ErpCountriesBo bo) {
        return toAjax(erpCountriesService.insertByBo(bo));
    }

    /**
     * 修改国家
     */
    @SaCheckPermission("business:countries:edit")
    @Log(title = "国家", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ErpCountriesBo bo) {
        return toAjax(erpCountriesService.updateByBo(bo));
    }

    /**
     * 删除国家
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:countries:remove")
    @Log(title = "国家", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        return toAjax(erpCountriesService.deleteWithValidByIds(List.of(ids), true));
    }
}
