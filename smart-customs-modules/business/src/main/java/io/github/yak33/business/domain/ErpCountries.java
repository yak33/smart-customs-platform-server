package io.github.yak33.business.domain;

import io.github.yak33.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 国家对象 erp_countries
 *
 * @author ZHANGCHAO
 * @date 2025-06-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("erp_countries")
public class ErpCountries extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 国家编码
     */
    private String code;

    /**
     * 国家名称
     */
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
    private Boolean isenabled;

    /**
     * 删除标记
     */
    @TableLogic
    private Integer delFlag;

    /**
     * 主键
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 预警级别（1低 2中 3高）
     */
    private String warnLevel;

    /**
     * 创建部门 - 数据库表中不存在此字段，排除映射
     */
    @TableField(exist = false)
    private Long createDept;
}
