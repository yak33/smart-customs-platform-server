package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.ErpHscode;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.yak33.common.core.validate.AddGroup;
import io.github.yak33.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 海关编码税则业务对象 erp_hscode
 *
 * @author ZHANGCHAO
 * @date 2026-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpHscode.class, reverseConvertGenerate = false)
public class ErpHscodeBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "ID不能为空", groups = { EditGroup.class })
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


}
