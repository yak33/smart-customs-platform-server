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
import io.github.yak33.business.domain.vo.ErpChinaPortsVo;
import io.github.yak33.business.domain.bo.ErpChinaPortsBo;
import io.github.yak33.business.service.IErpChinaPortsService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 口岸信息
 *
 * @author ZHANGCHAO
 * @date 2025-06-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/chinaPorts")
public class ErpChinaPortsController extends BaseController {

    private final IErpChinaPortsService erpChinaPortsService;

    /**
     * 查询口岸信息列表
     */
    @SaCheckPermission("business:chinaPorts:list")
    @GetMapping("/list")
    public TableDataInfo<ErpChinaPortsVo> list(ErpChinaPortsBo bo, PageQuery pageQuery) {
        return erpChinaPortsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出口岸信息列表
     */
    @SaCheckPermission("business:chinaPorts:export")
    @Log(title = "口岸信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ErpChinaPortsBo bo, HttpServletResponse response) {
        List<ErpChinaPortsVo> list = erpChinaPortsService.queryList(bo);
        ExcelUtil.exportExcel(list, "口岸信息", ErpChinaPortsVo.class, response);
    }

    /**
     * 获取口岸信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:chinaPorts:query")
    @GetMapping("/{id}")
    public R<ErpChinaPortsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(erpChinaPortsService.queryById(id));
    }

    /**
     * 新增口岸信息
     */
    @SaCheckPermission("business:chinaPorts:add")
    @Log(title = "口岸信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ErpChinaPortsBo bo) {
        return toAjax(erpChinaPortsService.insertByBo(bo));
    }

    /**
     * 修改口岸信息
     */
    @SaCheckPermission("business:chinaPorts:edit")
    @Log(title = "口岸信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ErpChinaPortsBo bo) {
        return toAjax(erpChinaPortsService.updateByBo(bo));
    }

    /**
     * 删除口岸信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:chinaPorts:remove")
    @Log(title = "口岸信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        return toAjax(erpChinaPortsService.deleteWithValidByIds(List.of(ids), true));
    }
}
