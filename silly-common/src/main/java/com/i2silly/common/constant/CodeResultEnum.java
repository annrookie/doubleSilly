package com.i2silly.common.constant;

/**
 * @author hanhan
 */

public enum CodeResultEnum {

    /**
     * 代码及结果定义
     */
    NULL_FAIL(10000, "参数不能为空"),
    FAIL(0, "返回错误"),
    SUCCESS(1, "返回成功");

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

    public void setCode(int code) {
        this.code = code;
    }

    public void setText(String text) {
        this.text = text;
    }
}
