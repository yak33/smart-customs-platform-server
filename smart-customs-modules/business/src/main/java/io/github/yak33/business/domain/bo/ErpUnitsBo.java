package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.ErpUnits;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 货物单位编码业务对象 erp_units
 *
 * @author ZHANGCHAO
 * @date 2025-10-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpUnits.class, reverseConvertGenerate = false)
public class ErpUnitsBo extends BaseEntity {

    /**
     * 主键
     */
    @NotBlank(message = "主键不能为空", groups = { EditGroup.class })
    private String id;

    /**
     * 单位编码
     */
    @NotBlank(message = "单位编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String code;

    /**
     * 单位名称
     */
    @NotBlank(message = "单位名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 英文代码
     */
    private String itemKey;

    /**
     * 单位英文名称
     */
    @NotBlank(message = "单位英文名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String enname;


}
