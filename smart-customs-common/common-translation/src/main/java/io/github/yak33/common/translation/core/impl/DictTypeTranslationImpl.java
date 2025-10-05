package io.github.yak33.common.translation.core.impl;

import io.github.yak33.common.core.service.DictService;
import io.github.yak33.common.core.utils.StringUtils;
import io.github.yak33.common.translation.annotation.TranslationType;
import io.github.yak33.common.translation.constant.TransConstant;
import io.github.yak33.common.translation.core.TranslationInterface;
import lombok.AllArgsConstructor;

/**
 * 字典翻译实现
 *
 * @author ZHANGCHAO
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.DICT_TYPE_TO_LABEL)
public class DictTypeTranslationImpl implements TranslationInterface<String> {

    private final DictService dictService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof String dictValue && StringUtils.isNotBlank(other)) {
            return dictService.getDictLabel(other, dictValue);
        }
        return null;
    }
}
