package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.GoodsPn;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 商品库业务对象 goods_pn
 *
 * @author ZHANGCHAO
 * @date 2025-10-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = GoodsPn.class, reverseConvertGenerate = false)
public class GoodsPnBo extends BaseEntity {

    /**
     * 商品流水号
     */
    @NotNull(message = "商品流水号不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 所属企业租户ID
     */
    @NotNull(message = "所属企业租户ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long ownerId;

    /**
     * 件号(物料号)
     */
    @NotBlank(message = "件号(物料号)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String partNumber;

    /**
     * 供应商
     */
    private String customerNo;

    /**
     * 附加码
     */
    private String additionalCode;

    /**
     * 申报品名
     */
    private String hsname;

    /**
     * 税号
     */
    private String hscode;

    /**
     * 申报要素
     */
    private String hsmodel;

    /**
     * 疫检代码
     */
    private String ciqCode;

    /**
     * 疫检名称
     */
    private String ciqName;

    /**
     * 申报要素备注
     */
    private String hsmemo;

    /**
     * 型号规格
     */
    private String model;

    /**
     * 中文品名
     */
    private String name;

    /**
     * 英文品名
     */
    private String enName;

    /**
     * 英文描述
     */
    private String enMemo;

    /**
     * 中文描述
     */
    private String cnMemo;

    /**
     * 单位
     */
    private String unit;

    /**
     * 包装
     */
    private String pack;

    /**
     * 是否危品
     */
    private String danger;

    /**
     * 危品等级
     */
    private String dangerLevel;

    /**
     * UN号
     */
    private String un;

    /**
     * 化工品号
     */
    private String chemicalsNo;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 原产国
     */
    private String country;

    /**
     * 净重
     */
    private BigDecimal netWeight;

    /**
     * 客户确认
     */
    private Boolean customerConfirm;

    /**
     * 是否审核
     */
    private Boolean isAudited;

    /**
     * 已验核实货
     */
    private Boolean isChecked;

    /**
     * 关联附件
     */
    private String attachments;

    /**
     * 商品类型（1原材料、2辅料、3成品、4半成品、5商品）
     */
    private String partType;

    /**
     * 待备案状态（0未标记，1已标记。默认未标记）
     */
    private Boolean partStatus;

    /**
     * 更新说明
     */
    private String updateRemark;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 最后更新人
     */
    private String lastUpdateBy;

    /**
     * 最后更新日期
     */
    private Date lastUpdateDate;


}
