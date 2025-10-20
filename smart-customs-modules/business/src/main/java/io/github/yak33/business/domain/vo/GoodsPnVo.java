package io.github.yak33.business.domain.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.yak33.business.domain.GoodsPn;
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
 * 商品库视图对象 goods_pn
 *
 * @author ZHANGCHAO
 * @date 2025-10-20
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = GoodsPn.class)
public class GoodsPnVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品流水号
     */
    @ExcelProperty(value = "商品流水号")
    private Long id;

    /**
     * 所属企业租户ID
     */
    @ExcelProperty(value = "所属企业租户ID")
    private Long ownerId;

    /**
     * 件号(物料号)
     */
    @ExcelProperty(value = "件号(物料号)")
    private String partNumber;

    /**
     * 供应商
     */
    @ExcelProperty(value = "供应商")
    private String customerNo;

    /**
     * 附加码
     */
    @ExcelProperty(value = "附加码")
    private String additionalCode;

    /**
     * 申报品名
     */
    @ExcelProperty(value = "申报品名")
    private String hsname;

    /**
     * 税号
     */
    @ExcelProperty(value = "税号")
    private String hscode;

    /**
     * 申报要素
     */
    @ExcelProperty(value = "申报要素")
    private String hsmodel;

    /**
     * 疫检代码
     */
    @ExcelProperty(value = "疫检代码")
    private String ciqCode;

    /**
     * 疫检名称
     */
    @ExcelProperty(value = "疫检名称")
    private String ciqName;

    /**
     * 申报要素备注
     */
    @ExcelProperty(value = "申报要素备注")
    private String hsmemo;

    /**
     * 型号规格
     */
    @ExcelProperty(value = "型号规格")
    private String model;

    /**
     * 中文品名
     */
    @ExcelProperty(value = "中文品名")
    private String name;

    /**
     * 英文品名
     */
    @ExcelProperty(value = "英文品名")
    private String enName;

    /**
     * 英文描述
     */
    @ExcelProperty(value = "英文描述")
    private String enMemo;

    /**
     * 中文描述
     */
    @ExcelProperty(value = "中文描述")
    private String cnMemo;

    /**
     * 单位
     */
    @ExcelProperty(value = "单位")
    private String unit;

    /**
     * 包装
     */
    @ExcelProperty(value = "包装")
    private String pack;

    /**
     * 是否危品
     */
    @ExcelProperty(value = "是否危品")
    private String danger;

    /**
     * 危品等级
     */
    @ExcelProperty(value = "危品等级")
    private String dangerLevel;

    /**
     * UN号
     */
    @ExcelProperty(value = "UN号")
    private String un;

    /**
     * 化工品号
     */
    @ExcelProperty(value = "化工品号")
    private String chemicalsNo;

    /**
     * 单价
     */
    @ExcelProperty(value = "单价")
    private BigDecimal price;

    /**
     * 原产国
     */
    @ExcelProperty(value = "原产国")
    private String country;

    /**
     * 净重
     */
    @ExcelProperty(value = "净重")
    private BigDecimal netWeight;

    /**
     * 客户确认
     */
    @ExcelProperty(value = "客户确认")
    private Boolean customerConfirm;

    /**
     * 是否审核
     */
    @ExcelProperty(value = "是否审核")
    private Boolean isAudited;

    /**
     * 已验核实货
     */
    @ExcelProperty(value = "已验核实货")
    private Boolean isChecked;

    /**
     * 关联附件
     */
    @ExcelProperty(value = "关联附件")
    private String attachments;

    /**
     * 商品类型（1原材料、2辅料、3成品、4半成品、5商品）
     */
    @ExcelProperty(value = "商品类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "1=原材料、2辅料、3成品、4半成品、5商品")
    private String partType;

    /**
     * 待备案状态（0未标记，1已标记。默认未标记）
     */
    @ExcelProperty(value = "待备案状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=未标记，1已标记。默认未标记")
    private Boolean partStatus;

    /**
     * 更新说明
     */
    @ExcelProperty(value = "更新说明")
    private String updateRemark;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 创建日期
     */
    @ExcelProperty(value = "创建日期")
    private Date createDate;

    /**
     * 最后更新人
     */
    @ExcelProperty(value = "最后更新人")
    private String lastUpdateBy;

    /**
     * 最后更新日期
     */
    @ExcelProperty(value = "最后更新日期")
    private Date lastUpdateDate;


}
