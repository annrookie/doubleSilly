package com.i2silly.common.exception;

import com.i2silly.common.constant.CodeResultEnum;

/**
 * 异常捕获
 *
 * @author hanhan
 * @version 1.0
 */
public class UtilException extends RuntimeException {

    public UtilException() {
        super();
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(CodeResultEnum rst) {
        String message = "异常代码【" + rst.getCode() + "】," + "异常信息【" + rst.getText() + "】";
        throw new UtilException(message);
    }
}
