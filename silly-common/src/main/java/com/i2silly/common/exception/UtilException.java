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


    public UtilException(CodeResultEnum codeResultEnum) {
        this(codeResultEnum.getText());
    }

}
