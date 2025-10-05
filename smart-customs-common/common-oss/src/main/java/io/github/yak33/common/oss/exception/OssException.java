package io.github.yak33.common.oss.exception;

import java.io.Serial;

/**
 * OSS异常类
 *
 * @author ZHANGCHAO
 */
public class OssException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public OssException(String msg) {
        super(msg);
    }

}
