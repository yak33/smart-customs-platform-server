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
import io.github.yak33.business.domain.vo.CustomerEnterpriseVo;
import io.github.yak33.business.domain.bo.CustomerEnterpriseBo;
import io.github.yak33.business.service.ICustomerEnterpriseService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 企业海关备案信息
 *
 * @author ZHANGCHAO
 * @date 2026-01-20
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/enterprise")
public class CustomerEnterpriseController extends BaseController {

    private final ICustomerEnterpriseService customerEnterpriseService;

    /**
     * 查询企业海关备案信息列表
     */
    @SaCheckPermission("business:enterprise:list")
    @GetMapping("/list")
    public TableDataInfo<CustomerEnterpriseVo> list(CustomerEnterpriseBo bo, PageQuery pageQuery) {
        return customerEnterpriseService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出企业海关备案信息列表
     */
    @SaCheckPermission("business:enterprise:export")
    @Log(title = "企业海关备案信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CustomerEnterpriseBo bo, HttpServletResponse response) {
        List<CustomerEnterpriseVo> list = customerEnterpriseService.queryList(bo);
        ExcelUtil.exportExcel(list, "企业海关备案信息", CustomerEnterpriseVo.class, response);
    }

    /**
     * 获取企业海关备案信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:enterprise:query")
    @GetMapping("/{id}")
    public R<CustomerEnterpriseVo> getInfo(@NotNull(message = "ID不能为空")
                                     @PathVariable String id) {
        return R.ok(customerEnterpriseService.queryById(id));
    }

    /**
     * 新增企业海关备案信息
     */
    @SaCheckPermission("business:enterprise:add")
    @Log(title = "企业海关备案信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CustomerEnterpriseBo bo) {
        return toAjax(customerEnterpriseService.insertByBo(bo));
    }

    /**
     * 修改企业海关备案信息
     */
    @SaCheckPermission("business:enterprise:edit")
    @Log(title = "企业海关备案信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CustomerEnterpriseBo bo) {
        return toAjax(customerEnterpriseService.updateByBo(bo));
    }

    /**
     * 删除企业海关备案信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:enterprise:remove")
    @Log(title = "企业海关备案信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "ID不能为空")
                          @PathVariable String[] ids) {
        return toAjax(customerEnterpriseService.deleteWithValidByIds(List.of(ids), true));
    }
}
