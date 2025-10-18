package io.github.yak33.business.domain;

import io.github.yak33.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 货物单位编码对象 erp_units
 *
 * @author ZHANGCHAO
 * @date 2025-10-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("erp_units")
public class ErpUnits extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 单位编码
     */
    private String code;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 英文代码
     */
    private String itemKey;

    /**
     * 单位英文名称
     */
    private String enname;

    /**
     * 删除标记
     */
    @TableLogic
    private Integer delFlag;

    /**
     * 创建部门 - 数据库表中不存在此字段，排除映射
     */
    @TableField(exist = false)
    private Long createDept;
}
