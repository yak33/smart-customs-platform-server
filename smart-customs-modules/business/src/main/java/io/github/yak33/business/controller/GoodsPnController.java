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
import io.github.yak33.business.domain.vo.GoodsPnVo;
import io.github.yak33.business.domain.bo.GoodsPnBo;
import io.github.yak33.business.service.IGoodsPnService;
import io.github.yak33.common.mybatis.core.page.TableDataInfo;

/**
 * 商品库
 *
 * @author ZHANGCHAO
 * @date 2025-10-20
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/business/goods")
public class GoodsPnController extends BaseController {

    private final IGoodsPnService goodsPnService;

    /**
     * 查询商品库列表
     */
    @SaCheckPermission("business:goods:list")
    @GetMapping("/list")
    public TableDataInfo<GoodsPnVo> list(GoodsPnBo bo, PageQuery pageQuery) {
        return goodsPnService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出商品库列表
     */
    @SaCheckPermission("business:goods:export")
    @Log(title = "商品库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(GoodsPnBo bo, HttpServletResponse response) {
        List<GoodsPnVo> list = goodsPnService.queryList(bo);
        ExcelUtil.exportExcel(list, "商品库", GoodsPnVo.class, response);
    }

    /**
     * 获取商品库详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("business:goods:query")
    @GetMapping("/{id}")
    public R<GoodsPnVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(goodsPnService.queryById(id));
    }

    /**
     * 新增商品库
     */
    @SaCheckPermission("business:goods:add")
    @Log(title = "商品库", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody GoodsPnBo bo) {
        return toAjax(goodsPnService.insertByBo(bo));
    }

    /**
     * 修改商品库
     */
    @SaCheckPermission("business:goods:edit")
    @Log(title = "商品库", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody GoodsPnBo bo) {
        return toAjax(goodsPnService.updateByBo(bo));
    }

    /**
     * 删除商品库
     *
     * @param ids 主键串
     */
    @SaCheckPermission("business:goods:remove")
    @Log(title = "商品库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(goodsPnService.deleteWithValidByIds(List.of(ids), true));
    }
}
