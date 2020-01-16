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

    PARAM_FAILURE(10004, "参数错误"),

    INDEX_OUT_BOUND(10005, "索引超出数组边界"),

    NO_SUCH_ALGORITHM(10006, "没有匹配的算法[NoSuchAlgorithmException]"),
    NO_SUCH_PADDING(10008, "没有匹配的填充方式[NoSuchPaddingException]"),
    BAD_PADDING(10010, "错误填充方式[BadPaddingException]"),
    ILLEGAL_BLOCK_SIZE(10011, "块大小不合法[IllegalBlockSizeException]"),

    UNSUPPORTED_ENCODING(10007, "编码格式不支持[UnsupportedEncodingException]"),

    INVALID_KEY(10009, "密匙无效[InvalidKey]"),

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
