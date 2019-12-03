package com.rookie.common.util;

import com.rookie.common.constant.ComConstant;
import com.rookie.common.constant.Mode;
import com.sun.istack.internal.NotNull;

/**
 * 字符串工具类
 *
 * @author hanhan
 */
public class StrUtil {

    // 常见判断 start-------------------------------------------------------

    /**
     * 字符串判空
     *
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() < ComConstant.ONE;
    }

    /**
     * 字符串是否不为空
     *
     * @param str 字符串
     * @return 字符串是否不为空
     */
    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为空白符
     *
     * @param str 字符串
     * @return true 是 | false 否
     */
    public static boolean isBlank(CharSequence str) {
        if (isEmpty(str)) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!CharUtil.isBlank(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 字符串
     * @return 是|否
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断字符串是否包含空白符
     *
     * @param str 字符串
     * @return 是|否
     */
    public static boolean hasBlank(String str) {
        if (isEmpty(str)) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (CharUtil.isBlank(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为数字字符串
     *
     * @param str 字符串
     * @return 是|否
     */
    public static boolean isNumberStr(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!CharUtil.isNumber(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为 "null" 或 "NULL"
     * 空检验通过为false
     *
     * @param str 需校验的字符串
     * @return 是|否
     */
    public static boolean isNullStr(String str) {
        return ComConstant.NULL.equalsIgnoreCase(str);
    }

    /**
     * 判断是否空 或 "null" 或 "NULL"
     * 校验为true： null "" "null" "NULL"
     *
     * @param str 需校验的字符串
     * @return 是|否
     */
    public static boolean isEmptyOrNull(String str) {
        return isEmpty(str) || ComConstant.NULL.equalsIgnoreCase(str);
    }

    /**
     * 判断字符串是否为"undefined"
     *
     * @param str 需判断的字符串
     * @return 是|否
     */
    public static boolean isUndefinedStr(String str) {
        return ComConstant.UNDEFINED.equalsIgnoreCase(str);
    }

    /**
     * 判断字符串是否空白符及空
     *
     * @param str 字符串
     * @return 是|否
     */
    public static boolean isEmptyOrBlank(String str) {
        return isEmpty(str) || isBlank(str);
    }

    /**
     * 判断是否为空或"undefined"
     *
     * @param str 字符串
     * @return 是|否
     */
    public static boolean isEmptyOrUndefined(String str) {
        return isEmpty(str) || isUndefinedStr(str);
    }

    /**
     * 判断是否为空、"undefined"、空白符、"null"
     * 空定义 "" 或 null
     *
     * @param str 字符串
     * @return 是|否
     */
    public static boolean isAllEmpty(String str) {
        return isEmpty(str) || isUndefinedStr(str) || isBlank(str) || isNullStr(str);
    }

    // 常见判断 end ---------------------------------------------------

    // change start ---------------------------------------------------

    /**
     * 字符串转数字字符串
     * 若没有数字则返回 "0"
     *
     * @param str 字符串
     * @return 数字字符串
     */
    public static String toNumStr(String str) {
        if (isEmpty(str)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (CharUtil.isNumber(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return isEmpty(sb.toString()) ? "0" : sb.toString();
    }

    /**
     * 字符串空转任意指定字符串
     *
     * @param str    需转换字符串
     * @param rstStr 转换后的字符串
     * @return 转换后的字符串
     */
    public static String nullToStr(String str, String rstStr) {
        return null == str ? rstStr : str;
    }

    /**
     * null字符串转""
     *
     * @param str 需转换的字符串
     * @return 转换完的字符串
     */
    public static String nullToEmpty(String str) {
        return nullToStr(str, ComConstant.EMPTY_STR);
    }

    /**
     * 空 转任意字符串
     * 空定义: null 或 ""
     *
     * @param str    需转换字符串
     * @param rstStr 转换的字符串
     * @return 字符串
     */
    public static String emptyToStr(String str, String rstStr) {
        return isEmpty(str) ? rstStr : str;
    }

    /**
     * 空白字符串转任意字符
     *
     * @param str    需转换字符串
     * @param rstStr 转换完的字符串
     * @return 转换完的字符串
     */
    public static String blankToStr(String str, String rstStr) {
        return isBlank(str) ? rstStr : str;
    }

    /**
     * 将空白符转换成指定标识
     *
     * @param str  字符串包含空白符
     * @param flag 标识
     * @return 转化完的字符串
     */
    public static String blankCharToStr(String str, String flag) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        if (isEmpty(flag)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (CharUtil.isBlank(str.charAt(i))) {
                sb.append(flag);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 空白字符串转 ""
     *
     * @param str 空白字符串
     * @return "" | str
     */
    public static String blankToEmpty(String str) {
        return blankToStr(str, ComConstant.EMPTY_STR);
    }

    /**
     * 空转null
     *
     * @param str 需转换字符串
     * @return null | str
     */
    public static String emptyToNull(String str) {
        return isEmpty(str) ? null : str;
    }

    // change end----------------------------------------------------

    // trim start----------------------------------------------------

    /**
     * 去除字符串两边空白符
     *
     * @param str  需要去除的字符串
     * @param mode 去除模式 TRIM_LEFT 左边| TRIM_RIGHT右边|TRIM_ALL 两边
     * @return 去除完的字符串
     */
    public static String trim(String str, Mode mode) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        int start = 0;
        int end = str.length();
        if (mode.getMode() <= 0) {
            while ((start < end) && CharUtil.isBlank(str.charAt(start))) {
                start++;
            }
        }
        if (mode.getMode() >= 0) {
            while ((start < end) && CharUtil.isBlank(str.charAt(end - 1))) {
                end--;
            }
        }
        if (start > 0 || end < str.length()) {
            return str.substring(start, end);
        }
        return str;
    }

    /**
     * 去除字符串两边空白符
     *
     * @param str 去除的字符串
     * @return 去除完的字符
     */
    public static String trim(String str) {
        return trim(str, Mode.TRIM_ALL);
    }

    /**
     * 去除字符串所有空白符
     *
     * @param str 字符串
     * @return 去完空的空白符
     */
    public static String trimBlank(String str) {
        return blankCharToStr(str, ComConstant.EMPTY_STR);
    }

    // include start --------------------------------------------------

    /**
     * 是否以某个字符开始
     *
     * @param str 字符串
     * @param c   字符
     * @return 是|否
     */
    public static boolean startWith(String str, char c) {
        return null != str && c == str.charAt(ComConstant.ZERO);
    }

    /**
     * 是否以某个字符串开始
     *
     * @param str          字符串
     * @param prefix       前缀
     * @param isIgnoreCase 是否忽略大小写
     * @return 是|否
     */
    public static boolean startWith(String str, String prefix, boolean isIgnoreCase) {
        if (str == null || prefix == null) {
            if (str == null && null == prefix) {
                return true;
            }
            return false;
        }
        if (isIgnoreCase) {
            return str.toLowerCase().startsWith(prefix.toLowerCase());
        } else {
            return str.startsWith(prefix);
        }
    }

    /**
     * 是否以某个字符串开始
     *
     * @param str    字符串
     * @param prefix 前缀
     * @return 是|否
     */
    public static boolean startWith(String str, String prefix) {
        return startWith(str, prefix, false);
    }

    /**
     * 是否以某个字符串开始并忽略大小写
     *
     * @param str    字符串
     * @param prefix 前缀
     * @return 是|否
     */
    public static boolean startIgnoreCaseWith(String str, String prefix) {
        return startWith(str, prefix, true);
    }

    /**
     * 是否以某个字符结束
     *
     * @param str 字符串
     * @param c   字符
     * @return 是|否
     */
    public static boolean endWith(String str, char c) {
        return null != str && str.charAt(str.length() - 1) == c;
    }

    /**
     * 是否以某个字符串结束
     *
     * @param str          字符串
     * @param suffix       结束字符串
     * @param isIgnoreCase 是否忽略大小写
     * @return 是|否
     */
    public static boolean endWith(String str, String suffix, boolean isIgnoreCase) {
        if (str == null || suffix == null) {
            if (str == null && suffix == null) {
                return true;
            }
            return false;
        }
        if (isIgnoreCase) {
            return str.toLowerCase().endsWith(suffix.toLowerCase());
        } else {
            return str.endsWith(suffix);
        }
    }

    /**
     * 是否以某个字符串结束
     *
     * @param str    字符串
     * @param suffix 结束字符串
     * @return 是|否
     */
    public static boolean endWith(String str, String suffix) {
        return endWith(str, suffix, false);
    }

    /**
     * 是否以某个字符串结束，忽略大小写
     *
     * @param str    字符串
     * @param suffix 结束字符串
     * @return 是|否
     */
    public static boolean endIgnoreCaseWith(String str, String suffix) {
        return endWith(str, suffix, true);
    }

    // include end ----------------------------------------------------

    //字母转换 start----------------------------------------------------

    /**
     * 首字母转大写
     * <br>
     * 若不是字母,则返回本身
     *
     * @param str 字符
     * @return 新字符串
     */
    public static String upperFirst(CharSequence str) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        char c = str.charAt(ComConstant.ZERO);
        if (CharUtil.isLowLetter(c)) {
            return Character.toUpperCase(c) + str.toString().substring(1);
        }
        return str.toString();
    }

    /**
     * 首字母转小写
     *
     * @param str 字符串
     * @return 转换完新字符串
     */
    public static String lowerFirst(CharSequence str) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        char c = str.charAt(ComConstant.ZERO);
        if (CharUtil.isUpLetter(c)) {
            return Character.toLowerCase(c) + str.toString().substring(1);
        }
        return str.toString();
    }

    // 字母转换 end -----------------------------------------------------

    //
}
