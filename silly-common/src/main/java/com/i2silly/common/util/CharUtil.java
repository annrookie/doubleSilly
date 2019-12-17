package com.i2silly.common.util;

/**
 * 字符工具类
 *
 * @author hanhan
 */
public class CharUtil {

    /**
     * 判断是否为空白字符
     *
     * @param c 字符
     * @return true 是空白符 | false不是空白符
     */
    public static boolean isBlank(char c) {
        return isBlank((int) c);
    }

    /**
     * 判断是否为空白字符
     *
     * @param c int
     * @return true 是空白符 | false不是空白符
     */
    public static boolean isBlank(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == '\ufeff' || c == '\u202a';
    }

    /**
     * 判断是否为数字
     *
     * @param c 字符
     * @return 是|否
     */
    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 是否为ASCII字符
     *
     * @param c 字符
     * @return 是|否
     */
    public static boolean isAscii(char c) {
        return c < 128;
    }

    /**
     * 是否为大写字母
     *
     * @param c 字符
     * @return 是|否
     */
    public static boolean isUpLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    /**
     * 是否为小写字母
     *
     * @param c 字符
     * @return 是|否
     */
    public static boolean isLowLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    /**
     * 是否为字母
     *
     * @param c 字符
     * @return 是|否
     */
    public static boolean isLetter(char c) {
        return isUpLetter(c) || isLowLetter(c);
    }

    /**
     * 判断是否为数字或26为字母
     *
     * @param c 字符
     * @return 是|否
     */
    public static boolean isNumOrLetter(char c) {
        return isLetter(c) || isNumber(c);
    }

    /**
     * 字符转字符串
     *
     * @param c 字符
     * @return 字符串
     */
    public static String toString(char c) {
        return String.valueOf(c);
    }
}
