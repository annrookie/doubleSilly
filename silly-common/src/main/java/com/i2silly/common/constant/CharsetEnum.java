package com.i2silly.common.constant;

/**
 * 字符枚举
 *
 * @author i2silly
 * @version 1.0.4
 */

public enum CharsetEnum {
    /**
     * GBK
     */
    GBK("GBK"),

    /**
     * UTF-8
     */
    UTF8_("UTF-8"),

    /**
     * UTF_8
     */
    UTF_8("UTF_8"),

    /**
     * UTF8
     */
    UTF8("UTF8");


    CharsetEnum(String text) {
        this.text = text;
    }

    public String text;

    public String getText() {
        return text;
    }
}
