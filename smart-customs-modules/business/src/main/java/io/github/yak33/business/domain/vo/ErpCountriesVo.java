package io.github.yak33.business.domain.vo;

import io.github.yak33.business.domain.ErpCountries;
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
 * 国家视图对象 erp_countries
 *
 * @author ZHANGCHAO
 * @date 2026-01-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ErpCountries.class)
public class ErpCountriesVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 国家编码
     */
    @ExcelProperty(value = "国家编码")
    private String code;

    /**
     * 国家名称
     */
    @ExcelProperty(value = "国家名称")
    private String name;

    /**
     * 自定义代码
     */
    @ExcelProperty(value = "自定义代码")
    private String standardCode;

    /**
     * 国家英文名称
     */
    @ExcelProperty(value = "国家英文名称")
    private String enname;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Boolean isenabled;

    /**
     * 预警级别（1低 2中 3高）
     */
    @ExcelProperty(value = "预警级别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "1=低,2=中,3=高")
    private String warnLevel;


}
