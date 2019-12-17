package com.i2silly.common.util;

import com.i2silly.common.constant.ComConstant;

import java.util.*;

/**
 * 随机生成对象工具类
 *
 * @author hanhan
 */
public class RandomUtil {

    /**
     * 随机产生六位字符
     *
     * @return 字符串
     */
    public static String random() {
        return random(ComConstant.EMPTY_STR, ComConstant.SIX);
    }

    /**
     * 随机生成六位大小写字母
     *
     * @return 六位字母字符串
     */
    public static String randomLetter() {
        return random(ComConstant.LETTER, ComConstant.SIX);
    }

    /**
     * 随机生成指定长度大小写字母
     *
     * @param length 指定长度
     * @return 指定长度字母字符串
     */
    public static String randomLetter(int length) {
        return random(ComConstant.LETTER, length);
    }

    /**
     * 随机生成指定长度小写字母串
     *
     * @return 指定长度字母字符串
     */
    public static String randomLowLetter(int length) {
        return random(ComConstant.LOW_LETTER, length);
    }

    /**
     * 随机生成6位小写字母串
     *
     * @return 6位字母字符串
     */
    public static String randomLowLetter() {
        return randomLowLetter(ComConstant.SIX);
    }

    /**
     * 随机生成指定长度大写字母串
     *
     * @param length 指定长度
     * @return 指定长度字母字符串
     */
    public static String randomUpLetter(int length) {
        return random(ComConstant.UP_LETTER, length);
    }

    /**
     * 随机生成六位大写字母
     *
     * @return 六位字母字符串
     */
    public static String randomUpLetter() {
        return randomUpLetter(ComConstant.SIX);
    }

    /**
     * 在指定字符串中生成指定长度的随机数
     *
     * @param targetStr 目标字符串/指定字符串
     * @param length    长度
     * @return 指定长度的随机数
     */
    public static String random(String targetStr, int length) {

        if (length < 0) {
            return ComConstant.EMPTY_STR;
        }
        StringBuilder sb = new StringBuilder();
        if (CommonUtil.isEmpty(targetStr)) {
            targetStr = ComConstant.CHARACTER;
        }
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(targetStr.length());
            sb.append(targetStr.charAt(index));
        }
        return sb.toString();
    }

    /**
     * 生成指定长度数字字符串
     *
     * @param length 自定长度
     * @return 指定长度数字字符串
     */
    public static String randomNum(int length) {
        return random(ComConstant.NUMBER, length);
    }

    /**
     * 随机生成6位数字
     *
     * @return 6位数字字符串
     */
    public static String randomNum() {
        return randomNum(ComConstant.SIX);
    }

    /**
     * 在目标字符串中，随机生成size个 长度length的字符串集合
     *
     * @param targetStr 目标字符串
     * @param length    字符串长度
     * @param size      集合个数
     * @return 随机长度、个数的字符串集合
     */
    public static List<String> randomList(String targetStr, int length, int size) {
        if (CommonUtil.isEmpty(targetStr) || length < 1 || size < 1) {
            return null;
        }
        List<String> list = NewUtil.list();
        for (int i = 0; i < size; i++) {
            list.add(random(targetStr, length));
        }
        return list;
    }

    /**
     * 随机生成size个length长度的字符串集合
     *
     * @param length 字符串长度
     * @param size   字符串个数
     * @return 字符串集合
     */
    public static List<String> randomList(int length, int size) {
        return randomList(ComConstant.CHARACTER, length, size);
    }

    /**
     * 随机生成指定个数的长度为6的字符串集合
     *
     * @param size 指定个数
     * @return 字符串集合
     */
    public static List<String> randomList(int size) {
        return randomList(ComConstant.CHARACTER, ComConstant.SIX, size);
    }

    /**
     * 随机生成size个length长度的字符串集合
     *
     * @param targetStr 目标字符串
     * @param length    字符串长度
     * @param size      字符串个数
     * @return 字符串集合
     */
    public static Set<String> randomSet(String targetStr, int length, int size) {
        List<String> list = randomList(targetStr, length, size);
        if (CommonUtil.isEmpty(list)) {
            return null;
        }
        return new HashSet<>(list);
    }

    /**
     * 生产uuid
     *
     * @return uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
