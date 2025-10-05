package io.github.yak33.business.domain.bo;

import io.github.yak33.business.domain.ErpCityports;
import io.github.yak33.common.mybatis.core.domain.BaseEntity;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 港口业务对象 erp_cityports
 *
 * @author ZHANGCHAO
 * @date 2025-06-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ErpCityports.class, reverseConvertGenerate = false)
public class ErpCityportsBo extends BaseEntity {

    /**
     * 主键
     */
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


}
