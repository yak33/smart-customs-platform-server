package io.github.yak33.business.domain.vo;

import io.github.yak33.business.domain.CustomerEnterprise;
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
 * 企业海关备案信息库视图对象 customer_enterprise
 *
 * @author ZHANGCHAO
 * @date 2025-10-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CustomerEnterprise.class)
public class CustomerEnterpriseVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @ExcelProperty(value = "流水号")
    private Long id;

    /**
     * 企业名称
     */
    @ExcelProperty(value = "企业名称")
    private String departName;

    /**
     * 社会统一信用代码
     */
    @ExcelProperty(value = "社会统一信用代码")
    private String socialCode;

    /**
     * 海关编码
     */
    @ExcelProperty(value = "海关编码")
    private String departcd;

    /**
     * 十位检验检疫编码
     */
    @ExcelProperty(value = "十位检验检疫编码")
    private String ciqCode;

    /**
     * AEO代码
     */
    @ExcelProperty(value = "AEO代码")
    private String aeo;

    /**
     * 企业信用等级
     */
    @ExcelProperty(value = "企业信用等级")
    private String creditRating;

    /**
     * 有效期
     */
    @ExcelProperty(value = "有效期")
    private String trrmOfValidity;

    /**
     * 注销
     */
    @ExcelProperty(value = "注销")
    private String cancellation;

    /**
     * 经营类别
     */
    @ExcelProperty(value = "经营类别")
    private String manageType;

    /**
     * 0=收发货人 1=生产销售单位/消费使用单位 2=申报单位
该参数，当选择 0 时，只返回备案类型是收发货人的，当选择 2 时，只选择备案类型是报关行的。选择 1 时，会返回所有的可用信息。
     */
    @ExcelProperty(value = "类型")
    private String type;


}
