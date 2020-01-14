package com.i2silly.common.constant;

/**
 * @author hanhan
 */

public enum CodeResultEnum {

    /**
     * 代码及结果定义
     */
    NULL_FAILURE(10001, "参数不能为空"),

    UNKNOWN_FAILURE(10002, "未知错误"),

    PARAM_FAILURE(10004,"参数错误"),

    INDEX_OUT_BOUND(10005,"索引超出数组边界"),

    MISMATCH_FAILURE(10003, "参数不匹配");


    private int code;
    private String text;

    CodeResultEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
