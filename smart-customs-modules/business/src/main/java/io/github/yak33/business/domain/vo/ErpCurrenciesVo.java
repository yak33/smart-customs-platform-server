package io.github.yak33.business.domain.vo;

import io.github.yak33.business.domain.ErpCurrencies;
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
 * 币制视图对象 erp_currencies
 *
 * @author ZHANGCHAO
 * @date 2026-01-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ErpCurrencies.class)
public class ErpCurrenciesVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ExcelProperty(value = "ID")
    private String id;

    /**
     * 编码 110等
     */
    @ExcelProperty(value = "币种编码")
    private String code;

    /**
     * 开证币种 USD/CYN等
     */
    @ExcelProperty(value = "开证币种")
    private String currency;

    /**
     * 币种名称
     */
    @ExcelProperty(value = "币种名称")
    private String name;

    /**
     * 币种英文名称
     */
    @ExcelProperty(value = "币种英文名称")
    private String enname;

    /**
     * 币种顺序
     */
    @ExcelProperty(value = "币种顺序")
    private Long currencyOrder;

    /**
     * 汇率
     */
    @ExcelProperty(value = "汇率")
    private String rate;

    /**
     * 阀值低
     */
    @ExcelProperty(value = "阀值低")
    private Long thresholdLow;

    /**
     * 阀值高
     */
    @ExcelProperty(value = "阀值高")
    private Long thresholdHigh;


}
