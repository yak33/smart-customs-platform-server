package io.github.yak33.business.domain.vo;

import io.github.yak33.business.domain.ErpUnits;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.yak33.common.excel.annotation.ExcelDictFormat;
import io.github.yak33.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 货物单位编码视图对象 erp_units
 *
 * @author ZHANGCHAO
 * @date 2025-10-18
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ErpUnits.class)
public class ErpUnitsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private String id;

    /**
     * 单位编码
     */
    @ExcelProperty(value = "单位编码")
    private String code;

    /**
     * 单位名称
     */
    @ExcelProperty(value = "单位名称")
    private String name;

    /**
     * 英文代码
     */
    @ExcelProperty(value = "英文代码")
    private String itemKey;

    /**
     * 单位英文名称
     */
    @ExcelProperty(value = "单位英文名称")
    private String enname;


}
