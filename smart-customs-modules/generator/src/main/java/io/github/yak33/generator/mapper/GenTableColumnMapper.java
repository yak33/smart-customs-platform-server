package io.github.yak33.generator.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import io.github.yak33.common.mybatis.core.mapper.BaseMapperPlus;
import io.github.yak33.generator.domain.GenTableColumn;

/**
 * 业务字段 数据层
 *
 * @author ZHANGCHAO
 */
@InterceptorIgnore(dataPermission = "true", tenantLine = "true")
public interface GenTableColumnMapper extends BaseMapperPlus<GenTableColumn, GenTableColumn> {

}
