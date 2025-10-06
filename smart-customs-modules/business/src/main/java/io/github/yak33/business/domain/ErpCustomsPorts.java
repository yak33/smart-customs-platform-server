package io.github.yak33.business.domain;

import io.github.yak33.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 关区口岸对象 erp_customs_ports
 *
 * @author ZHANGCHAO
 * @date 2025-10-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("erp_customs_ports")
public class ErpCustomsPorts extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 关区编码
     */
    private String customsPortCode;

    /**
     * 关区名称
     */
    private String name;

    /**
     * 关区全称
     */
    private String langName;

    /**
     * DELETEDAT
     */
    private Date deletedAt;

    /**
     * 删除标记（0正常 1已删除）
     */
    @TableLogic
    private Long delFlag;

    /**
     * 创建部门 - 数据库表中不存在此字段，排除映射
     */
    @TableField(exist = false)
    private Long createDept;
}
