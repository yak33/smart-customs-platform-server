package io.github.yak33.common.translation.core.impl;

import io.github.yak33.common.core.service.OssService;
import io.github.yak33.common.translation.annotation.TranslationType;
import io.github.yak33.common.translation.constant.TransConstant;
import io.github.yak33.common.translation.core.TranslationInterface;
import lombok.AllArgsConstructor;

/**
 * OSS翻译实现
 *
 * @author ZHANGCHAO
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.OSS_ID_TO_URL)
public class OssUrlTranslationImpl implements TranslationInterface<String> {

    private final OssService ossService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof String ids) {
            return ossService.selectUrlByIds(ids);
        } else if (key instanceof Long id) {
            return ossService.selectUrlByIds(id.toString());
        }
        return null;
    }
}
