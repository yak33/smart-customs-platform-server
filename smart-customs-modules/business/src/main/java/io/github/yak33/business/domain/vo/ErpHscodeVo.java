package io.github.yak33.business.domain.vo;

import io.github.yak33.business.domain.ErpHscode;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 海关编码申报税则相关视图对象 erp_hscode
 *
 * @author ZHANGCHAO
 * @date 2025-09-08
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ErpHscode.class)
public class ErpHscodeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 税号
     */
    @ExcelProperty(value = "税号")
    private String hscode;

    /**
     * 商品名称
     */
    @ExcelProperty(value = "商品名称")
    private String gname;

    /**
     * 监管条件
     */
    @ExcelProperty(value = "监管条件")
    private String controLmark;

    /**
     * 法一单位
     */
    @ExcelProperty(value = "法一单位")
    private String unit1;

    /**
     * 法一单位名称
     */
    @ExcelProperty(value = "法一单位名称")
    private String unit1name;

    /**
     * 法二
     */
    @ExcelProperty(value = "法二")
    private String unit2;

    /**
     * 法二名称
     */
    @ExcelProperty(value = "法二名称")
    private String unit2name;

    /**
     * 检验检疫条件
     */
    @ExcelProperty(value = "检验检疫条件")
    private String inspmonitorcond;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String notes;

    /**
     * 申报要素
     */
    @ExcelProperty(value = "申报要素")
    private String sbys;

    /**
     * 商检编码：名称
     */
    @ExcelProperty(value = "商检编码：名称")
    private String ciqlist;

    /**
     * 商检编码
     */
    @ExcelProperty(value = "商检编码")
    private String ciqclass;

    /**
     * 申报要素必填项
     */
    @ExcelProperty(value = "申报要素必填项")
    private String sbysRequired;

    /**
     * 是否启用
     */
    @ExcelProperty(value = "是否启用")
    private Long isEnable;


}
