package io.github.yak33.business.domain.vo;

import io.github.yak33.business.domain.ErpCityports;
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
 * 港口视图对象 erp_cityports
 *
 * @author ZHANGCHAO
 * @date 2025-06-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ErpCityports.class)
public class ErpCityportsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private String id;

    /**
     * 编码
     */
    @ExcelProperty(value = "编码")
    private String cityportCode;

    /**
     * 中文名
     */
    @ExcelProperty(value = "中文名")
    private String cnname;

    /**
     * 英文名
     */
    @ExcelProperty(value = "英文名")
    private String enname;

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
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;


}
