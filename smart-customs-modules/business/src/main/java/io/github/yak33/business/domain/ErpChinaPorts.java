package io.github.yak33.business.domain;

import io.github.yak33.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 口岸信息对象 erp_china_ports
 *
 * @author ZHANGCHAO
 * @date 2025-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("erp_china_ports")
public class ErpChinaPorts extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID")
    private String id;

    /**
     * 出境口岸/国内口岸编码
     */
    private String chinaPortCode;

    /**
     * 出境口岸/国内口岸名称
     */
    private String name;

    /**
     * 出境口岸/国内口岸英文名称
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
