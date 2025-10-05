package io.github.yak33.business.domain.vo;

import io.github.yak33.business.domain.ErpChinaPorts;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.yak33.common.excel.annotation.ExcelDictFormat;
import io.github.yak33.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 口岸信息视图对象 erp_china_ports
 *
 * @author ZHANGCHAO
 * @date 2025-06-21
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ErpChinaPorts.class)
public class ErpChinaPortsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ExcelProperty(value = "ID")
    private String id;

    /**
     * 出境口岸/国内口岸编码
     */
    @ExcelProperty(value = "出境口岸/国内口岸编码")
    private String chinaPortCode;

    /**
     * 出境口岸/国内口岸名称
     */
    @ExcelProperty(value = "出境口岸/国内口岸名称")
    private String name;

    /**
     * 出境口岸/国内口岸英文名称
     */
    @ExcelProperty(value = "出境口岸/国内口岸英文名称")
    private String enname;

    /**
     * 租户ID
     */
    @ExcelProperty(value = "租户ID")
    private Long tenantId;

    /**
     * 创建人
     */
    @ExcelProperty(value = "创建人")
    private String createBy;

    /**
     * 删除标记（0正常 1已删除）
     */
    @ExcelProperty(value = "删除标记", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=正常,1=已删除")
    private Long delFlag;

    /**
     * 更新日期
     */
    @ExcelProperty(value = "更新日期")
    private Date updateTime;

    /**
     * 创建日期
     */
    @ExcelProperty(value = "创建日期")
    private Date createTime;

    /**
     * 更新人
     */
    @ExcelProperty(value = "更新人")
    private String updateBy;


}
