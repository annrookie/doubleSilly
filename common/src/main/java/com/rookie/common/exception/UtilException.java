package com.rookie.common.exception;

import com.rookie.common.constant.CodeResult;

/**
 * 异常捕获
 *
 * @author hanhan
 * @version 1.0
 * @date 2019-10-30 16:55:11
 */
public class UtilException extends RuntimeException {

    public UtilException() {
        super();
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(CodeResult rst) {
        String message = "异常代码【" + rst.getCode() + "】," + "异常信息【" + rst.getText() + "】";
        throw new UtilException(message);
    }
}
