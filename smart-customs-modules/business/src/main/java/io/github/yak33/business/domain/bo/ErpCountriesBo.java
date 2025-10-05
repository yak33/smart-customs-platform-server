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
 * @date 2025-06-29
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
    private String enname;

    /**
     * 是否启用
     */
    @NotNull(message = "是否启用不能为空", groups = { EditGroup.class })
    private Boolean isenabled;

    /**
     * 主键
     */
    private String id;


}
