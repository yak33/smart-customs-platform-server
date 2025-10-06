package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.ErpCustomsPorts;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 关区口岸业务对象 erp_customs_ports
 *
 * @author ZHANGCHAO
 * @date 2025-10-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpCustomsPorts.class, reverseConvertGenerate = false)
public class ErpCustomsPortsBo extends BaseEntity {

    /**
     * 主键
     */
    private String id;

    /**
     * 关区编码
     */
    @NotBlank(message = "关区编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String customsPortCode;

    /**
     * 关区名称
     */
    @NotBlank(message = "关区名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 关区全称
     */
    private String langName;


}
