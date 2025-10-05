package io.github.yak33.business.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.yak33.business.domain.ErpCurrencies;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;

/**
 * 币制业务对象 erp_currencies
 *
 * @author ZHANGCHAO
 * @date 2025-06-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpCurrencies.class, reverseConvertGenerate = false)
public class ErpCurrenciesBo extends BaseEntity {

    /**
     * 主键
     */
    private String id;

    /**
     * 编码 110等
     */
    @NotBlank(message = "币制编码不能为空", groups = {AddGroup.class, EditGroup.class})
    private String code;

    /**
     * 开证币种 USD/CYN等
     */
    @NotBlank(message = "币制不能为空", groups = {AddGroup.class, EditGroup.class})
    private String currency;

    /**
     * 币种名称
     */
    @NotBlank(message = "币制名称不能为空", groups = {AddGroup.class, EditGroup.class})
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
