package io.github.yak33.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 企业海关备案信息库对象 customer_enterprise
 *
 * @author ZHANGCHAO
 * @date 2025-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("customer_enterprise")
public class CustomerEnterprise implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId(value = "ID")
    private Long id;

    /**
     * 企业名称
     */
    private String departName;

    /**
     * 社会统一信用代码
     */
    private String socialCode;

    /**
     * 海关编码
     */
    private String departcd;

    /**
     * 十位检验检疫编码
     */
    private String ciqCode;

    /**
     * AEO代码
     */
    private String aeo;

    /**
     * 企业信用等级
     */
    private String creditRating;

    /**
     * 有效期
     */
    private String trrmOfValidity;

    /**
     * 注销
     */
    private String cancellation;

    /**
     * 经营类别
     */
    private String manageType;

    /**
     * 0=收发货人 1=生产销售单位/消费使用单位 2=申报单位
该参数，当选择 0 时，只返回备案类型是收发货人的，当选择 2 时，只选择备案类型是报关行的。选择 1 时，会返回所有的可用信息。
     */
    private String type;

}
