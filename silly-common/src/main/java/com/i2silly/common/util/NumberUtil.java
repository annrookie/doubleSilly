package com.i2silly.common.util;

import com.i2silly.common.constant.ComConstant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hanhan
 */
public class NumberUtil {

    /**
     * 格式化数字
     * 10000 =&gt; 10,000
     *
     * @param num 数字
     * @return 格式化完的数字字符串
     */
    public static String numberFormat(int num) {
        return numberFormat((long) num);
    }

    /**
     * 格式化数字
     * 1000 =&gt; 1,000
     *
     * @param num 数字
     * @return 格式化完的数字字符串
     */
    public static String numberFormat(long num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        if (length <= ComConstant.THREE) {
            return numStr;
        }
        int times = length / 3;
        if (length % ComConstant.THREE != 0) {
            times += 1;
        }
        List<String> list = new ArrayList<>();
        String temp;
        for (int i = 0; i < times; i++) {
            int min = Math.max(length - (i + 1) * ComConstant.THREE, 0);
            temp = numStr.substring(min, length - i * ComConstant.THREE);
            list.add(temp);
        }
        // list反转
        Collections.reverse(list);
        return CollectionUtil.join(list, ComConstant.COMMA);
    }

    /**
     * 字符串数字格式化
     * "1000" =&gt; "1,000"
     *
     * @param numStr 数字字符串
     * @return 格式完的字符串
     */
    public static String numberFormat(String numStr) {
        return numberFormat(Long.parseLong(StrUtil.toNumStr(numStr)));
    }

    /**
     * double数字格式化
     *
     * @param num     浮点型double
     * @param decimal 保留位数小数
     * @return 格式完字符串
     */
    public static String numberFormat(double num, int decimal) {
        return numberFormat(BigDecimal.valueOf(num), decimal);
    }

    /**
     * 数字格式化
     *
     * @param bg      数
     * @param decimal 保留小数位
     * @return 格式完的字符串
     */
    public static String numberFormat(BigDecimal bg, int decimal) {
        if (null == bg) {
            StringBuilder sb = new StringBuilder();
            sb.append("0.");
            for (int i = 0; i < decimal; i++) {
                sb.append("0");
            }
            return sb.toString();
        }
        String s = bg.setScale(decimal, BigDecimal.ROUND_HALF_UP).toString();
        String first = s.substring(0, s.indexOf(ComConstant.POINT));
        String last = s.substring(s.indexOf(ComConstant.POINT));
        return numberFormat(first) + last;
    }

    /**
     * 数字格式化
     *
     * @param num 数字
     * @return 格式完字符串 默认保留两位小数
     */
    public static String numberFormat(double num) {
        return numberFormat(num, ComConstant.TWO);
    }

    /**
     * 数字格式化
     *
     * @param bg 数字
     * @return 格式完字符串 默认保留两位小数
     */
    public static String numberFormat(BigDecimal bg) {
        return numberFormat(bg, ComConstant.TWO);
    }
}
