package io.github.yak33.common.translation.core.impl;

import io.github.yak33.common.core.service.DeptService;
import io.github.yak33.common.translation.annotation.TranslationType;
import io.github.yak33.common.translation.constant.TransConstant;
import io.github.yak33.common.translation.core.TranslationInterface;
import lombok.AllArgsConstructor;

/**
 * 部门翻译实现
 *
 * @author ZHANGCHAO
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.DEPT_ID_TO_NAME)
public class DeptNameTranslationImpl implements TranslationInterface<String> {

    private final DeptService deptService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof String ids) {
            return deptService.selectDeptNameByIds(ids);
        } else if (key instanceof Long id) {
            return deptService.selectDeptNameByIds(id.toString());
        }
        return null;
    }
}
