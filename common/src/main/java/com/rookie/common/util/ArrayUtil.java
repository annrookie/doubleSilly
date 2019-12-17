package com.rookie.common.util;

import com.rookie.common.constant.ArrayFilter;
import com.rookie.common.constant.ComConstant;
import com.rookie.common.filter.ComFilter;
import com.rookie.common.filter.impl.FilterEmpty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 数组工具类
 *
 * @author hanhan
 * @version 1.0
 * @date 2019/11/28
 */
public class ArrayUtil {

    public static final int INDEX_NOT_FOUNT = -1;

    // 常见判断start-------------------------------------------------------------------

    /**
     * 判断对象是否为数组
     *
     * @param obj 对象
     * @return 是否为数组
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            return false;
        }
        return obj.getClass().isArray();
    }

    /**
     * 判断是否为空
     *
     * @param t   泛型数组
     * @param <T> 泛型
     * @return true | false
     */
    public static <T> boolean isEmpty(T[] t) {
        return null == t || t.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr int数组
     * @return true | false
     */
    public static boolean isEmpty(int[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr short数组
     * @return true | false
     */
    public static boolean isEmpty(short[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr byte数组
     * @return true | false
     */
    public static boolean isEmpty(byte[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr long数组
     * @return true | false
     */
    public static boolean isEmpty(long[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr float数组
     * @return true | false
     */
    public static boolean isEmpty(float[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr long数组
     * @return true | false
     */
    public static boolean isEmpty(double[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr char数组
     * @return true | false
     */
    public static boolean isEmpty(char[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isEmpty(boolean[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 判断是否不为空
     *
     * @param t boolean数组
     * @return true | false
     */
    public static <T> boolean isNotEmpty(T[] t) {
        return !isEmpty(t);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(int[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(short[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(byte[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(long[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(float[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(double[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(char[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断是否不为空
     *
     * @param arr boolean数组
     * @return true | false
     */
    public static boolean isNotEmpty(boolean[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 判断可变参数数组是否存在空白符
     *
     * @param arr 数组
     * @param <T> 可变参数
     * @return 是|否
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean hasNull(T... arr) {
        if (arr == null) {
            return true;
        }
        if (isNotEmpty(arr)) {
            for (T t : arr) {
                if (t == null) {
                    return true;
                }
            }
        }
        return false;
    }

    // 常见判断end -----------------------------------------------------

    // 拆装包 start------------------------------------------------------

    /**
     * int数组装包
     *
     * @param arr int数组
     * @return Integer数组
     */
    public static Integer[] warp(int... arr) {
        if (null == arr) {
            return null;
        }
        Integer[] rst = new Integer[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * short数组装包
     *
     * @param arr short数组
     * @return Short数组
     */
    public static Short[] warp(short... arr) {
        if (null == arr) {
            return null;
        }
        Short[] rst = new Short[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * byte数组装包
     *
     * @param arr byte数组
     * @return Byte数组
     */
    public static Byte[] warp(byte... arr) {
        if (null == arr) {
            return null;
        }
        Byte[] rst = new Byte[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * long数组装包
     *
     * @param arr long数组
     * @return Long数组
     */
    public static Long[] warp(long... arr) {
        if (null == arr) {
            return null;
        }
        Long[] rst = new Long[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * float数组装包
     *
     * @param arr float数组
     * @return Float数组
     */
    public static Float[] warp(float... arr) {
        if (null == arr) {
            return null;
        }
        Float[] rst = new Float[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * double数组装包
     *
     * @param arr double数组
     * @return Double数组
     */
    public static Double[] warp(double... arr) {
        if (null == arr) {
            return null;
        }
        Double[] rst = new Double[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * char数组装包
     *
     * @param arr char数组
     * @return Character数组
     */
    public static Character[] warp(char... arr) {
        if (null == arr) {
            return null;
        }
        Character[] rst = new Character[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * boolean数组装包
     *
     * @param arr boolean数组
     * @return Boolean数组
     */
    public static Boolean[] warp(boolean... arr) {
        if (null == arr) {
            return null;
        }
        Boolean[] rst = new Boolean[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Integer数组拆包
     *
     * @param arr Integer数组
     * @return int数组
     */
    public static int[] unWarp(Integer... arr) {
        if (null == arr) {
            return null;
        }
        int[] rst = new int[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Byte数组拆包
     *
     * @param arr Byte数组
     * @return byte数组
     */
    public static byte[] unWarp(Byte... arr) {
        if (null == arr) {
            return null;
        }
        byte[] rst = new byte[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Short数组拆包
     *
     * @param arr Short数组
     * @return short数组
     */
    public static short[] unWarp(Short... arr) {
        if (null == arr) {
            return null;
        }
        short[] rst = new short[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Long数组拆包
     *
     * @param arr Long数组
     * @return long数组
     */
    public static long[] unWarp(Long... arr) {
        if (null == arr) {
            return null;
        }
        long[] rst = new long[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Character数组拆包
     *
     * @param arr Character数组
     * @return char数组
     */
    public static char[] unWarp(Character... arr) {
        if (null == arr) {
            return null;
        }
        char[] rst = new char[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Boolean数组拆包
     *
     * @param arr Boolean数组
     * @return boolean数组
     */
    public static boolean[] unWarp(Boolean... arr) {
        if (null == arr) {
            return null;
        }
        boolean[] rst = new boolean[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Float数组拆包
     *
     * @param arr Float数组
     * @return float数组
     */
    public static float[] unWarp(Float... arr) {
        if (null == arr) {
            return null;
        }
        float[] rst = new float[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    /**
     * Double数组拆包
     *
     * @param arr Double数组
     * @return double数组
     */
    public static double[] unWarp(Double... arr) {
        if (null == arr) {
            return null;
        }
        double[] rst = new double[arr.length];
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                rst[i] = arr[i];
            }
        }
        return rst;
    }

    // 拆装包end -----------------------------------------------------

    // 数组操作start---------------------------------------------------

    /**
     * 数组转为字符串数组
     *
     * @param obj 对象数组
     * @return 字符串数组
     */
    public static String[] toStringArr(Object... obj) {
        if (null == obj) {
            return null;
        }
        String[] rst = new String[obj.length];
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] == null) {
                rst[i] = ComConstant.NULL_STR;
            } else {
                rst[i] = obj[i].toString();
            }
        }
        return rst;
    }

    /**
     * 拼接数组
     *
     * @param arr          数组
     * @param format       拼接格式
     * @param isAddBracket 是否添加[]
     * @param isAddSpace   是否带空格
     * @param filter       过滤条件
     * @param <T>          泛型数组
     * @return 拼接完的字符串
     */
    public static <T> String join(T[] arr, String format, boolean isAddBracket, boolean isAddSpace, ArrayFilter filter) {
        if (isEmpty(arr)) {
            return ComConstant.EMPTY_STR;
        }
        Object firstParam = filterParam(arr[0], filter);
        StringBuilder sb = new StringBuilder();
        // 是否添加括号
        if (isAddBracket) {
            sb.append(ComConstant.LEFT_BRACKET);
        }
        sb.append(firstParam);
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                sb.append(format);
                // 是否添加空格
                if (isAddSpace) {
                    sb.append(ComConstant.SPACE);
                }
                // 过滤
                sb.append(filterParam(arr[i], filter));
            }
        }
        // 是否添加括号
        if (isAddBracket) {
            sb.append(ComConstant.RIGHT_BRACKET);
        }
        return sb.toString();
    }

    /**
     * 拼接数组
     *
     * @param arr 数组
     * @param <T> 泛型
     * @return 字符串
     */
    public static <T> String join(T[] arr) {
        return join(arr, ComConstant.COMMA, true, true, ArrayFilter.NONE);
    }

    /**
     * 拼接字符串
     *
     * @param arr    数组
     * @param format 拼接字符
     * @param filter 过滤[NONE,EMPTY,BLANK,ALL]
     * @param <T>    泛型
     * @return 拼接完的字符串
     */
    public static <T> String join(T[] arr, String format, ArrayFilter filter) {
        return join(arr, format, true, true, filter);
    }

    /**
     * 数组toString方法
     *
     * @param arr 数组
     * @param <T> 泛型
     * @return 字符串
     */
    public static <T> String toString(T[] arr) {
        if (isEmpty(arr)) {
            return ComConstant.EMPTY_STR;
        }
        // 获取arr的规范名称
        String canonicalName = arr.getClass().getCanonicalName();
        // 截取最后面数组表示形式
        String arrName = canonicalName.substring(canonicalName.lastIndexOf(ComConstant.POINT) + 1, canonicalName.length() - 2);
        StringBuilder sb = new StringBuilder(arrName);
        String str = join(arr);
        sb.append(str);
        return sb.toString();
    }

    /**
     * 数组过滤空级别
     *
     * @param t           泛型参数
     * @param filterLevel 过滤级别
     * @param <T>         泛型
     * @return 对象
     */
    private static <T> Object filterParam(T t, ArrayFilter filterLevel) {
        Object rstObj;
        switch (filterLevel) {
            case EMPTY:
                rstObj = CommonUtil.isEmpty(t) ? ComConstant.EMPTY_STR : t;
                break;
            case BLANK:
                rstObj = StrUtil.isBlank(t.toString()) ? ComConstant.EMPTY_STR : t;
                break;
            case ALL:
                rstObj = (CommonUtil.isEmpty(t) || StrUtil.isBlank(t.toString())) ? ComConstant.EMPTY_STR : t;
                break;
            default:
                rstObj = t;
        }
        return rstObj;
    }

    /**
     * 数组过滤
     *
     * @param <T>    泛型
     * @param arr    需要过滤的数组
     * @param filter 过滤方法接口
     * @return 对象数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] arr, ComFilter filter) {
        if (isEmpty(arr)) {
            return newArray(arr, 0);
        }
        List<T> list = new ArrayList<>();
        for (T t : arr) {
            if (!filter.filter(t)) {
                list.add(t);
            }
        }
        T[] rst = newArray(arr, list.size());
        return list.toArray(rst);
    }

    /**
     * 数组过滤空
     *
     * @param arr 数组
     * @param <T> 泛型
     * @return 过滤完的数组
     */
    public static <T> T[] filterEmpty(T[] arr) {
        return filter(arr, new FilterEmpty());
    }


    /**
     * 创建指定类型的数组
     *
     * @param componentType 类型
     * @param length        长度
     * @param <T>           泛型
     * @return 改类型数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<?> componentType, int length) {
        return (T[]) Array.newInstance(componentType, length);
    }

    /**
     * 创建指定类型数组
     *
     * @param arr    泛型数组
     * @param length 长度
     * @param <T>    泛型
     * @return 指定长度的类型数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(T[] arr, int length) {
        return (T[]) Array.newInstance(getComponentType(arr), length);
    }

    /**
     * 获取对象的类型
     *
     * @param obj 对象
     * @return 对象的类型
     */
    public static Class<?> getComponentType(Object obj) {
        return null == obj ? null : obj.getClass().getComponentType();
    }

    /**
     * 在数组末尾添加元素
     *
     * @param arr      数组
     * @param elements 需要追加的元素或数字
     * @param <T>      泛型
     * @return 追加完的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> Object[] append(T[] arr, T... elements) {
        return insert(arr, arr.length, elements);
    }

    /**
     * 在数组中，插入元素或数组，返回Object数组
     *
     * @param arr     指定数组
     * @param index   插入位置
     * @param element 插入的元素或数组
     * @param <T>     泛型
     * @return 对象数组
     */
    @SuppressWarnings("unchecked")
    public static <T> Object[] insert(T[] arr, int index, T... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        Object[] result = new Object[arr.length + element.length];
        int arrSrc = 0, arrLength = arr.length,
                eleSrc = arrLength, eleLength = element.length;
        if (index <= 0) {
            arrSrc = eleLength;
            eleSrc = 0;
        }
        if (index > 0 && index < arr.length) {
            arrLength = index;
            eleSrc = index;
        }
        System.arraycopy(arr, 0, result, arrSrc, arrLength);
        System.arraycopy(element, 0, result, eleSrc, eleLength);
        if (index > 0 && index < arr.length) {
            System.arraycopy(arr, index, result, index + eleLength, arr.length - index);
        }
        return result;
    }
    //
}
