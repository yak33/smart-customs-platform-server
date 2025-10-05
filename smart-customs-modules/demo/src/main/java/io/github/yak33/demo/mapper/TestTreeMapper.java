package io.github.yak33.demo.mapper;

import io.github.yak33.common.mybatis.annotation.DataColumn;
import io.github.yak33.common.mybatis.annotation.DataPermission;
import io.github.yak33.common.mybatis.core.mapper.BaseMapperPlus;
import io.github.yak33.demo.domain.TestTree;
import io.github.yak33.demo.domain.vo.TestTreeVo;

/**
 * 测试树表Mapper接口
 *
 * @author ZHANGCHAO
 * @date 2021-07-26
 */
@DataPermission({
    @DataColumn(key = "deptName", value = "dept_id"),
    @DataColumn(key = "userName", value = "user_id")
})
public interface TestTreeMapper extends BaseMapperPlus<TestTree, TestTreeVo> {

}
