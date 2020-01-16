package com.i2silly.common.constant;

/**
 * @author i2silly
 * @version 1.0.4
 */

public enum CipherEnum {
    /**
     * 哈希sha1
     */
    SHA("SHA"),
    /**
     * 哈希sha224
     */
    SHA224("SHA-224"),
    /**
     * 哈希sha256
     */
    SHA256("SHA-256"),
    /**
     * 哈希sha384
     */
    SHA384("SHA-384"),
    /**
     * 哈希sha512
     */
    SHA512("SHA-512"),
    /**
     * MD5
     */
    MD5("MD5"),
    /**
     * HMACMD5
     */
    HMACMD5("HmacMD5"),
    /**
     * HMACSHA1
     */
    HMACSHA1("HmacSHA1"),
    /**
     * HMACSHA256
     */
    HMACSHA256("HmacSHA256"),
    /**
     * HMACSHA224
     */
    HMACSHA224("HmacSHA224"),
    /**
     * HMACSHA384
     */
    HMACSHA384("HmacSHA384"),
    /**
     * HMACSHA512
     */
    HMACSHA512("HmacSHA512"),

    /**
     * AES
     */
    AES("AES");

    private String val;

    CipherEnum(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
