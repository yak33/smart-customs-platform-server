package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.ErpCountries;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 国家业务对象 erp_countries
 *
 * @author ZHANGCHAO
 * @date 2026-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpCountries.class, reverseConvertGenerate = false)
public class ErpCountriesBo extends BaseEntity {

    /**
     * 国家编码
     */
    @NotBlank(message = "国家编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String code;

    /**
     * 国家名称
     */
    @NotBlank(message = "国家名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 自定义代码
     */
    private String standardCode;

    /**
     * 国家英文名称
     */
    @NotBlank(message = "国家英文名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String enname;

    /**
     * 是否启用
     */
    private Boolean isenabled;

    /**
     * 主键
     */
    @NotBlank(message = "主键不能为空", groups = { EditGroup.class })
    private String id;

    /**
     * 预警级别（1低 2中 3高）
     */
    private String warnLevel;


}
