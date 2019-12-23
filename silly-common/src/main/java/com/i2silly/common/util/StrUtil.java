package com.i2silly.common.util;

import com.i2silly.common.constant.ComConstant;
import com.i2silly.common.constant.ModeEnum;

import java.util.UUID;

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
    public static boolean isMAxEmpty(String str) {
        return isEmpty(str) || isUndefinedStr(str) || isBlank(str) || isNullStr(str);
    }

    /**
     * 判断是否全部为小写字符串
     *
     * @param str 需校验的字符串
     * @return 是否为小写字符串
     */
    public static boolean isLowerCase(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!CharUtil.isLowLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为大写字符串
     *
     * @param str 需判断的字符串
     * @return 是否为大写字符串
     */
    public static boolean isUpperCase(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!CharUtil.isUpLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
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

    /**
     * 大小写字母互相转换
     *
     * @param str 字符串
     * @return 转换完的字符串
     */
    public static String caseChange(String str) {
        if (isEmpty(str)) {
            return "";
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (CharUtil.isLowLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else if (CharUtil.isUpLetter(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }

    /**
     * 将指定字符串区间内（左包右不包）内的字符替换为指定字符
     * 开始索引&gt;结束索引 || 开始索引&gt;字符串长度 || 结束索引&lt;0 <br>
     * 返回原本字符串
     *
     * @param str         替换字符串
     * @param startIndex  开始索引 (包含)
     * @param endIndex    结束索引 (不包含)
     * @param replaceChar 指定字符
     * @return 替换为的字符串
     */
    public static String replace(String str, int startIndex, int endIndex, char replaceChar) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        int length = str.length();
        if (startIndex > length || endIndex <= ComConstant.ZERO || startIndex > endIndex) {
            return str;
        }
        int min = Math.max(startIndex, 0);
        int max = Math.min(endIndex, length);
        char[] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            if (i >= min && i < max) {
                chars[i] = replaceChar;
            }
        }
        return new String(chars);
    }

    /**
     * 将指定字符串区间内（左包右不包）内的字符替换为指定字符串
     * 开始索引&gt;结束索引 || 开始索引&gt;字符串长度 || 结束索引&lt;0 <br>
     * 返回原本字符串
     *
     * @param str        需替换字符串
     * @param startIndex 开始索引（包含）
     * @param endIndex   结束索引（不包含）
     * @param replaceStr 替换的字符串
     * @return 替换完的字符串
     */
    public static String replace(String str, int startIndex, int endIndex, String replaceStr) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        int length = str.length();
        if (startIndex > length || endIndex <= ComConstant.ZERO || startIndex > endIndex) {
            return str;
        }
        int min = Math.max(startIndex, 0);
        int max = Math.min(endIndex, length);
        if (min == 0 && max == length) {
            return replaceStr;
        }
        StringBuilder sb = new StringBuilder();
        if (min > 0) {
            String first = str.substring(0, min);
            sb.append(first);
        }
        sb.append(replaceStr);
        if (max < length) {
            String last = str.substring(max);
            sb.append(last);
        }
        return sb.toString();
    }

    /**
     * 将指定字符串区间内（开始到结束）内的字符替换为指定字符
     * 开始索引&gt;结束索引 || 开始索引&gt;字符串长度 || 结束索引&lt;0 <br>
     * 返回原本字符串
     *
     * @param str         替换字符串
     * @param startIndex  开始索引 (包含)
     * @param replaceChar 指定字符
     * @return 替换为的字符串
     */
    public static String replace(String str, int startIndex, char replaceChar) {
        return isEmpty(str) ? ComConstant.EMPTY_STR : replace(str, startIndex, str.length(), replaceChar);
    }

    /**
     * 将指定字符串区间内（开始到结束）内的字符替换为指定字符串
     * 开始索引&gt;结束索引 || 开始索引&gt;字符串长度 || 结束索引&lt;0 <br>
     * 返回原本字符串
     *
     * @param str        需替换字符串
     * @param startIndex 开始索引（包含）
     * @param replaceStr 替换的字符串
     * @return 替换完的字符串
     */
    public static String replace(String str, int startIndex, String replaceStr) {
        return isEmpty(str) ? ComConstant.EMPTY_STR : replace(str, startIndex, str.length(), replaceStr);
    }

    /**
     * 字符串中间部分隐藏
     * 在minLength长度（含）以内都会被隐藏
     *
     * @param str          需隐藏的字符串
     * @param minLength    在此范围内（含）都被隐藏
     * @param hideLength   隐藏符号长度，若首尾显示字符串长度和&gt;字符串总长度，则隐藏符号长度为字符串总长度-首尾字符串长度和
     * @param hideFlagChar 隐藏符号
     * @return 隐藏后的字符串
     */
    public static String hide(String str, char hideFlagChar, int minLength, int hideLength) {
        if (str.length() <= minLength) {
            return newStr(hideFlagChar, str.length());
        }
        // 三等分四舍五入
        int i = Math.round((float) str.length() / ComConstant.THREE);
        i = Math.min(i, ComConstant.FOUR);
        int max = str.length() - i;
        hideLength = Math.min(hideLength, str.length() - 2 * i);
        String hideFlag = newStr(hideFlagChar, hideLength);
        return replace(str, i, max, hideFlag);
    }

    /**
     * 字符串中间部分隐藏，首尾默认最大显示4个字符<br>
     * 默认4个字符以内的字符串都隐藏<br>
     * 默认隐藏符号为 *
     *
     * @param str 需隐藏的字符串
     * @return 隐藏完的字符串
     */
    public static String hide(String str) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        return hide(str, ComConstant.START, ComConstant.FOUR, str.length());
    }

    /**
     * 下换线字符串拼接形式转为驼峰式
     *
     * @param str 需要进行转换的字符串
     * @return 转换完的字符串
     */
    public static String underlineToHump(String str) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        String[] arr = str.split(String.valueOf(ComConstant.UNDERLINE));
        arr[0] = arr[0].toLowerCase();
        for (int i = 1; i < arr.length; i++) {
            arr[i] = upperFirst(arr[i].toLowerCase());
        }
        return concat(arr);
    }

    /**
     * 驼峰式转为下划线形式
     *
     * @param str 字符串
     * @return 转换完的字符串
     */
    public static String humpToUnderline(String str) {
        if (isEmpty(str)) {
            return ComConstant.EMPTY_STR;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (CharUtil.isUpLetter(str.charAt(i))) {
                sb.append(ComConstant.UNDERLINE);
            }
            sb.append(str.charAt(i));
        }
        return startWith(sb.toString(), "_") ? sb.toString().substring(1).toLowerCase() : sb.toString().toLowerCase();
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
    public static String trim(String str, ModeEnum mode) {
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
        return trim(str, ModeEnum.TRIM_ALL);
    }

    /**
     * 去除字符串两边所有空白符
     *
     * @param str 字符串
     * @return 去完空的空白符
     */
    public static String cleanBlank(String str) {
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

    // add start -------------------------------------------------------

    /**
     * 添加前缀
     * 弱添加：当需添加的字符串包含前缀，则返回，若无则添加
     *
     * @param str     需添加的字符串
     * @param prefix  前缀
     * @param weekAdd 是否弱添加
     * @return 字符串
     */
    public static String addPrefix(String str, String prefix, boolean weekAdd) {
        if (isEmpty(prefix)) {
            return str;
        }
        if (weekAdd) {
            return startWith(str, prefix) ? str : prefix + str;
        } else {
            return addPrefix(str, prefix);
        }
    }

    /**
     * 添加前缀
     *
     * @param str    字符串
     * @param prefix 前缀
     * @return 添加完字符串
     */
    public static String addPrefix(String str, String prefix) {
        return isEmpty(prefix) ? str : prefix + str;
    }

    /**
     * 添加后缀
     * 弱添加：当需添加的字符串包含后缀，则返回，若无则添加
     *
     * @param str     需添加的字符串
     * @param suffix  后缀
     * @param weekAdd 是否弱添加
     * @return 字符串
     */
    public static String addSuffix(String str, String suffix, boolean weekAdd) {
        if (isEmpty(suffix)) {
            return str;
        }
        if (weekAdd) {
            return endWith(str, suffix) ? str : str + suffix;
        } else {
            return addSuffix(str, suffix);
        }
    }

    /**
     * 添加后缀
     *
     * @param str    字符串
     * @param suffix 后缀
     * @return 添加完字符串
     */
    public static String addSuffix(String str, String suffix) {
        return isEmpty(suffix) ? str : str + suffix;
    }

    /**
     * 添加前后缀
     *
     * @param str     字符串
     * @param prefix  前缀
     * @param suffix  后缀
     * @param weekAdd 是否弱添加
     * @return 添加完字符串
     */
    public static String addPrefixAndSuffix(String str, String prefix, String suffix, boolean weekAdd) {
        String s;
        s = addPrefix(str, prefix, weekAdd);
        return addSuffix(s, suffix, weekAdd);
    }

    /**
     * 添加前后缀
     *
     * @param str    需添加字符串
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 添加完的字符串
     */
    public static String addPrefixAndSuffix(String str, String prefix, String suffix) {
        String s = addPrefix(str, prefix);
        return addSuffix(s, suffix);
    }

    // add end ----------------------------------------------------------

    // random start------------------------------------------------------

    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuid() {
        return getUuid().replaceAll(ComConstant.MID_LINE, ComConstant.EMPTY_STR);
    }

    // random end ------------------------------------------------------

    // join start -----------------------------------------------------

    /**
     * 将一个或多个字符串拼接在一起
     *
     * @param strs 可变字符串
     * @return 拼接完字符串
     */
    public static String concat(CharSequence... strs) {
        if (null == strs || strs.length < 1) {
            return ComConstant.EMPTY_STR;
        }
        StringBuilder sb = new StringBuilder();
        for (CharSequence str : strs) {
            if (isNotEmpty(str)) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    // join end -----------------------------------------------------

    // other start --------------------------------------------------

    /**
     * 获取长度
     *
     * @param ch 字符序列
     * @return 长度
     */
    public static int length(CharSequence ch) {
        return isEmpty(ch) ? 0 : ch.length();
    }

    /**
     * 生产指定字符，自定长度的字符串
     *
     * @param length 长度
     * @param c      字符
     * @return 字符串
     */
    public static String newStr(char c, int length) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = c;
        }
        return new String(chars);
    }

    /**
     * 字符串反转
     * eg: "abcd" =&gt; "dcba"
     *
     * @param str 字符串
     * @return 反转完的字符串
     */
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    /**
     * 将字符串等分
     *
     * @param str       字符串
     * @param divideLen 等分字符串长度
     * @return 等分完的数组
     */
    public static String[] avgDivide(String str, int divideLen) {
        if (isEmpty(str) || divideLen == 0) {
            return new String[0];
        }
        int length = str.length();
        if (length < divideLen) {
            return new String[]{str};
        }
        int times = length % divideLen == 0 ? length / divideLen : length / divideLen + 1;
        String[] arr = new String[times];
        for (int i = 0; i < times; i++) {
            int max = Math.min((i + 1) * divideLen, length);
            arr[i] = str.substring(i * divideLen, max);
        }
        return arr;
    }
}
