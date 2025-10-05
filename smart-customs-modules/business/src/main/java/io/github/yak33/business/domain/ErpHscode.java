package io.github.yak33.business.domain;

import io.github.yak33.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 海关编码申报税则相关对象 erp_hscode
 *
 * @author ZHANGCHAO
 * @date 2025-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("erp_hscode")
public class ErpHscode extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID")
    private Long id;

    /**
     * 税号
     */
    private String hscode;

    /**
     * 商品名称
     */
    private String gname;

    /**
     * 监管条件
     */
    private String controLmark;

    /**
     * 法一单位
     */
    private String unit1;

    /**
     * 法一单位名称
     */
    private String unit1name;

    /**
     * 法二
     */
    private String unit2;

    /**
     * 法二名称
     */
    private String unit2name;

    /**
     * 检验检疫条件
     */
    private String inspmonitorcond;

    /**
     * 备注
     */
    private String notes;

    /**
     * 申报要素
     */
    private String sbys;

    /**
     * 商检编码：名称
     */
    private String ciqlist;

    /**
     * 商检编码
     */
    private String ciqclass;

    /**
     * 申报要素必填项
     */
    private String sbysRequired;

    /**
     * 是否启用
     */
    private Long isEnable;

    /**
     * 创建部门 - 数据库表中不存在此字段，排除映射
     */
    @TableField(exist = false)
    private Long createDept;
}
