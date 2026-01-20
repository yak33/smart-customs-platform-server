package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.ErpCurrencies;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 币制业务对象 erp_currencies
 *
 * @author ZHANGCHAO
 * @date 2026-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpCurrencies.class, reverseConvertGenerate = false)
public class ErpCurrenciesBo extends BaseEntity {

    /**
     * 主键
     */
    @NotBlank(message = "主键不能为空", groups = { EditGroup.class })
    private String id;

    /**
     * 编码 110等
     */
    @NotBlank(message = "币种编码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String code;

    /**
     * 开证币种 USD/CYN等
     */
    @NotBlank(message = "开证币种不能为空", groups = { AddGroup.class, EditGroup.class })
    private String currency;

    /**
     * 币种名称
     */
    @NotBlank(message = "币种名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 币种英文名称
     */
    private String enname;

    /**
     * 币种顺序
     */
    private Long currencyOrder;

    /**
     * 汇率
     */
    private String rate;

    /**
     * 阀值低
     */
    private Long thresholdLow;

    /**
     * 阀值高
     */
    private Long thresholdHigh;


}
