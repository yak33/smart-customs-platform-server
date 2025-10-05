package io.github.yak33.system.domain.vo;

import io.github.yak33.common.translation.annotation.Translation;
import io.github.yak33.common.translation.constant.TransConstant;
import io.github.yak33.system.domain.SysOss;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * OSS对象存储视图对象 sys_oss
 *
 * @author ZHANGCHAO
 */
@Data
@AutoMapper(target = SysOss.class)
public class SysOssVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对象存储主键
     */
    private Long ossId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 原名
     */
    private String originalName;

    /**
     * 文件后缀名
     */
    private String fileSuffix;

    /**
     * URL地址
     */
    private String url;

    /**
     * 扩展字段
     */
    private String ext1;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上传人
     */
    private String createBy;

    /**
     * 上传人名称
     */
    @Translation(type = TransConstant.USER_ID_TO_NAME, mapper = "createBy")
    private String createByName;

    /**
     * 服务商
     */
    private String service;


}
