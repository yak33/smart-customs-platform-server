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
import io.github.yak33.business.domain.vo.ErpCustomsPortsVo;
import io.github.yak33.business.domain.bo.ErpCustomsPortsBo;
import io.github.yak33.business.service.IErpCustomsPortsService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 关区口岸
 *
 * @author ZHANGCHAO
 * @date 2025-10-06
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/customsPorts")
public class ErpCustomsPortsController extends BaseController {

    private final IErpCustomsPortsService erpCustomsPortsService;

    /**
     * 查询关区口岸列表
     */
    @SaCheckPermission("business:customsPorts:list")
    @GetMapping("/list")
    public TableDataInfo<ErpCustomsPortsVo> list(ErpCustomsPortsBo bo, PageQuery pageQuery) {
        return erpCustomsPortsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出关区口岸列表
     */
    @SaCheckPermission("business:customsPorts:export")
    @Log(title = "关区口岸", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ErpCustomsPortsBo bo, HttpServletResponse response) {
        List<ErpCustomsPortsVo> list = erpCustomsPortsService.queryList(bo);
        ExcelUtil.exportExcel(list, "关区口岸", ErpCustomsPortsVo.class, response);
    }

    /**
     * 获取关区口岸详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:customsPorts:query")
    @GetMapping("/{id}")
    public R<ErpCustomsPortsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(erpCustomsPortsService.queryById(id));
    }

    /**
     * 新增关区口岸
     */
    @SaCheckPermission("business:customsPorts:add")
    @Log(title = "关区口岸", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ErpCustomsPortsBo bo) {
        return toAjax(erpCustomsPortsService.insertByBo(bo));
    }

    /**
     * 修改关区口岸
     */
    @SaCheckPermission("business:customsPorts:edit")
    @Log(title = "关区口岸", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ErpCustomsPortsBo bo) {
        return toAjax(erpCustomsPortsService.updateByBo(bo));
    }

    /**
     * 删除关区口岸
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:customsPorts:remove")
    @Log(title = "关区口岸", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        return toAjax(erpCustomsPortsService.deleteWithValidByIds(List.of(ids), true));
    }
}
