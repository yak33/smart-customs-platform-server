package io.github.yak33.business.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.yak33.business.domain.ErpCustomsPorts;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 关区口岸视图对象 erp_customs_ports
 *
 * @author ZHANGCHAO
 * @date 2025-10-06
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ErpCustomsPorts.class)
public class ErpCustomsPortsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private String id;

    /**
     * 关区编码
     */
    @ExcelProperty(value = "关区编码")
    private String customsPortCode;

    /**
     * 关区名称
     */
    @ExcelProperty(value = "关区名称")
    private String name;

    /**
     * 关区全称
     */
    @ExcelProperty(value = "关区全称")
    private String langName;


}
