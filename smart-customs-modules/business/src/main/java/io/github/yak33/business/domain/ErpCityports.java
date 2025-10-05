package io.github.yak33.business.domain;

import io.github.yak33.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 港口对象 erp_cityports
 *
 * @author ZHANGCHAO
 * @date 2025-06-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("erp_cityports")
public class ErpCityports extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 编码
     */
    private String cityportCode;

    /**
     * 中文名
     */
    private String cnname;

    /**
     * 英文名
     */
    private String enname;

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
