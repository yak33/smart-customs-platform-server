package io.github.yak33.business.domain;

import io.github.yak33.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 币制对象 erp_currencies
 *
 * @author ZHANGCHAO
 * @date 2025-06-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("erp_currencies")
public class ErpCurrencies extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 编码 110等
     */
    private String code;

    /**
     * 开证币种 USD/CYN等
     */
    private String currency;

    /**
     * 币种名称
     */
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
     * 删除标记
     */
    @TableLogic
    private String delFlag;

    /**
     * 阀值低
     */
    private Long thresholdLow;

    /**
     * 阀值高
     */
    private Long thresholdHigh;

    /**
     * 创建部门 - 数据库表中不存在此字段，排除映射
     */
    @TableField(exist = false)
    private Long createDept;
}
