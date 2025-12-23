package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.ErpCityports;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 港口业务对象 erp_cityports
 *
 * @author ZHANGCHAO
 * @date 2025-12-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpCityports.class, reverseConvertGenerate = false)
public class ErpCityportsBo extends BaseEntity {

    /**
     * 主键
     */
    @NotBlank(message = "主键不能为空", groups = { EditGroup.class })
    private String id;

    /**
     * 编码
     */
    @NotBlank(message = "编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cityportCode;

    /**
     * 中文名
     */
    @NotBlank(message = "中文名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cnname;

    /**
     * 英文名
     */
    @NotBlank(message = "英文名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String enname;


}
