package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.CustomerEnterprise;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 企业海关备案信息业务对象 customer_enterprise
 *
 * @author ZHANGCHAO
 * @date 2026-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CustomerEnterprise.class, reverseConvertGenerate = false)
public class CustomerEnterpriseBo extends BaseEntity {

    /**
     * 流水号
     */
    @NotBlank(message = "ID不能为空", groups = { EditGroup.class })
    private String id;

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


}
