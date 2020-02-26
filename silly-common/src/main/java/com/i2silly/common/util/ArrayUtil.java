package com.i2silly.common.util;

import com.i2silly.common.constant.CodeResultEnum;
import com.i2silly.common.constant.ComConstant;
import com.i2silly.common.exception.UtilException;
import com.i2silly.common.filter.ComFilter;
import com.i2silly.common.filter.impl.FilterEmpty;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 数组工具类
 *
 * @author hanhan
 * @version 1.0.3
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
     * @return 是|否
     */
    public static boolean hasNull(Object... arr) {
        if (arr == null) {
            return true;
        }
        if (isNotEmpty(arr)) {
            for (Object t : arr) {
                if (t == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 数组是否存在空
     *
     * @param arr 数组
     * @return 是|否
     */
    public static boolean hasEmpty(Object... arr) {
        if (isEmpty(arr)) {
            return true;
        }
        for (Object o : arr) {
            if (CommonUtil.isEmpty(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断二维数组是否全为空
     *
     * @param arr 二维数组
     * @return 是|否
     */
    public static boolean isAllEmpty(Object[][] arr) {
        if (isEmpty(arr)) {
            return true;
        }
        for (Object[] o : arr) {
            if (isNotEmpty(o)) {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断二维数组全部不为空
     *
     * @param arr 二维数组
     * @return 是|否
     */
    public static boolean isAllNotEmpty(Object[][] arr) {
        if (isEmpty(arr)) {
            return false;
        }
        for (Object[] o : arr) {
            if (isEmpty(o)) {
                return false;
            }
        }
        return true;
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
    public static String[] toStringArr(Object[] obj) {
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
     * @return 拼接完的字符串
     */
    @SuppressWarnings("unchecked")
    public static String join(Object[] arr, String format, boolean isAddBracket, boolean isAddSpace, ComFilter filter) {
        if (isEmpty(arr)) {
            return ComConstant.EMPTY_STR;
        }
        StringBuilder sb = new StringBuilder();
        // 是否添加括号
        if (isAddBracket) {
            sb.append(ComConstant.LEFT_BRACKET);
        }
        if (arr.length > 0) {
            for (Object o : arr) {
                if (filter.filter(o)) {
                    sb.append(o);
                    sb.append(format);
                }
                // 是否添加空格
                if (isAddSpace) {
                    sb.append(ComConstant.SPACE);
                }
            }
        }
        String str;
        if (isAddSpace) {
            str = sb.substring(0, sb.length() - 2);
        } else {
            str = sb.substring(0, sb.length() - 1);
        }
        // 是否添加括号
        if (isAddBracket) {
            str += ComConstant.RIGHT_BRACKET;
        }
        return str;
    }

    /**
     * 拼接数组
     *
     * @param arr 数组
     * @return 字符串
     */
    public static String join(Object[] arr) {
        return join(arr, ComConstant.COMMA, true, true, new FilterEmpty());
    }

    /**
     * 拼接数组
     *
     * @param arr    数组
     * @param format 拼接字符
     * @param filter 过滤
     * @return 拼接完的字符串
     */
    public static String join(Object[] arr, String format, ComFilter filter) {
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

    // 过滤start------------------------


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
            if (filter.filter(t)) {
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

    // 过滤end------------------------
    // 创建新数组start------------------------

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

    // 创建新数组end------------------------
    // 获取数组类型start------------------------

    /**
     * 获取对象的类型，不是数组返回null
     *
     * @param obj 对象
     * @return 对象的类型
     */
    public static Class<?> getComponentType(Object obj) {
        return null == obj ? null : obj.getClass().getComponentType();
    }

    /**
     * 获取数组元素类型,不是数组返回null
     *
     * @param arrClass 数组类
     * @return 数组元素类型
     */
    public static Class<?> getComponentType(Class<?> arrClass) {
        return null == arrClass ? null : arrClass.getComponentType();
    }


    // 获取数组类型end------------------------
    // 追加、添加所有、添加或更新所有数组start------------------------

    /**
     * 在数组末尾添加元素
     *
     * @param arr      数组
     * @param elements 需要追加的元素或数字
     * @param <T>      泛型
     * @return 追加完的数组
     */
    public static <T> Object[] append(T[] arr, Object... elements) {
        return insert(arr, arr.length, elements);
    }

    /**
     * 在数组中，插入元素或数组，返回Object数组<br>
     * 可通过getClass()获取初始类型
     *
     * @param arr     指定数组
     * @param index   插入位置
     * @param element 插入的元素或数组
     * @param <T>     泛型
     * @return 对象数组
     */
    public static <T> Object[] insert(T[] arr, int index, Object[] element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        Object[] result;
        if (getComponentType(arr) == getComponentType(element)) {
            result = newArray(getComponentType(arr), arr.length + element.length);
        } else {
            result = new Object[arr.length + element.length];
        }
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

    /**
     * 数组替换或者追加<br>
     * 源数组长度小于索引长度，则追加数组<br>
     * 源数组长度大于索引长度，则进行替换
     *
     * @param arr     源数组
     * @param index   起始索引
     * @param element 追加可变参
     * @param <T>     泛型
     * @return 追加或替换完的数组【Object数组】
     */
    public static <T> Object[] replaceOrAppend(T[] arr, int index, Object[] element) {
        if (isEmpty(arr) || index <= 0) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        if (index < arr.length) {
            Object[] obj = new Object[index + element.length];
            System.arraycopy(arr, 0, obj, 0, index);
            System.arraycopy(element, 0, obj, index, element.length);
            return obj;
        }
        return append(arr, element);
    }

    /**
     * 添加所有数组<br>
     * 同一类型数据可强制转换为该类型数组，若不是则返回Object数组类型
     * 自动过滤空
     *
     * @param arrays 泛型数组
     * @param <T>    泛型
     * @return 合并后的数组
     */
    @SafeVarargs
    public static <T> Object[] addAll(T[]... arrays) {
        if (arrays == null) {
            return newArray(Object.class, 0);
        }
        // 只有一个数组直接返回
        if (arrays.length == 1) {
            return arrays[0];
        }
        // 同一类型数组标识
        boolean flag = true;
        // 获取首个数组的类型
        Class<?> type = getComponentType(arrays[0]);
        int length = 0;
        for (T[] array : arrays) {
            if (isNotEmpty(array)) {
                length += array.length;
                // 判断是否含有其他类型的数组【与首个数组类型不一致】，则生成Object数组
                if (type != getComponentType(array)) {
                    flag = false;
                }
            }
        }
        Object[] rst;
        if (flag) {
            rst = newArray(type, length);
        } else {
            rst = newArray(Object.class, length);
        }
        int srcLength = 0;
        for (T[] array : arrays) {
            if (isNotEmpty(array)) {
                System.arraycopy(array, 0, rst, srcLength, array.length);
                srcLength += array.length;
            }
        }
        return rst;
    }
    // 追加、添加所有、添加或更新所有数组end------------------------
    // 映射键值对start--------------------------

    /**
     * 将两个数组合并为键值对形式<br>
     * 若数组长度不一致，取最短<br>
     * 若键数组或值数组为空，则返回空
     *
     * @param key    键数组
     * @param value  值数组
     * @param isSort 是否有序
     * @param <K>    键泛型
     * @param <V>    值泛型
     * @return 键值对
     */
    public static <K, V> Map<K, V> mergeToMap(K[] key, V[] value, boolean isSort) {
        if (isEmpty(key) || isEmpty(value)) {
            return null;
        }
        Map<K, V> map;
        if (isSort) {
            map = new LinkedHashMap<>();
        } else {
            map = new HashMap<>();
        }
        int size = Math.min(key.length, value.length);
        for (int i = 0; i < size; i++) {
            map.put(key[i], value[i]);
        }
        return map;
    }

    /**
     * 将两个数组合并为键值对形式<br>
     * 若数组长度不一致，取最短<br>
     * 若键数组或值数组为空，则返回空
     *
     * @param key   键数组
     * @param value 值数组
     * @param <K>   键泛型
     * @param <V>   值泛型
     * @return 键值对
     */
    public static <K, V> Map<K, V> mergeToMap(K[] key, V[] value) {
        return mergeToMap(key, value, false);
    }

    // 映射键值对end----------------------------

    // index操作start

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static <T> int indexOf(T[] array, Object val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 元素是否存在数组中，忽略大小写
     *
     * @param array 数组
     * @param val   元素
     * @param <T>   泛型
     * @return 索引
     */
    public static <T> int indexOfIgnoreCase(T[] array, Object val) {
        if (null != array && array.length > 0) {
            boolean b;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null && val != null) {
                    b = array[i].toString().equalsIgnoreCase(val.toString());
                } else {
                    b = array[i] == val;
                }
                if (b) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @param <T>   泛型
     * @return 索引
     */
    public static <T> int lastIndexOf(T[] array, Object val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @param <T>   泛型
     * @return 是|否
     */
    public static <T> boolean contains(T[] array, Object val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含值数组
     *
     * @param array 数组
     * @param vals  被包含的数组
     * @param <T>   泛型
     * @return 是|否
     */
    public static <T> boolean containsAll(T[] array, Object[] vals) {
        if (null == array || vals == null) {
            return false;
        }
        for (Object val : vals) {
            if (indexOf(array, val) == INDEX_NOT_FOUNT) {
                return false;
            }
        }
        return true;
    }

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int indexOf(int[] array, int val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int lastIndexOf(int[] array, int val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @return 是|否
     */
    public static boolean contains(int[] array, int val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int indexOf(byte[] array, byte val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int lastIndexOf(byte[] array, byte val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @return 是|否
     */
    public static boolean contains(byte[] array, byte val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int indexOf(short[] array, short val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int lastIndexOf(short[] array, short val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @return 是|否
     */
    public static boolean contains(short[] array, short val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int indexOf(long[] array, long val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int lastIndexOf(long[] array, long val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @return 是|否
     */
    public static boolean contains(long[] array, long val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int indexOf(float[] array, float val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int lastIndexOf(float[] array, float val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @return 是|否
     */
    public static boolean contains(float[] array, float val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int indexOf(double[] array, double val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int lastIndexOf(double[] array, double val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @return 是|否
     */
    public static boolean contains(double[] array, double val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }

    /**
     * 查询元素是否在数组中
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int indexOf(char[] array, char val) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 从数组后方开始查找元素
     *
     * @param array 数组
     * @param val   元素
     * @return 索引
     */
    public static int lastIndexOf(char[] array, char val) {
        if (null != array) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == val) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUNT;
    }

    /**
     * 判断数组是否包含元素
     *
     * @param array 数组
     * @param val   元素
     * @return 是|否
     */
    public static boolean contains(char[] array, char val) {
        return indexOf(array, val) > INDEX_NOT_FOUNT;
    }
    // index操作end

    // sub操作start

    /**
     * 截取数组
     *
     * @param arr   数组
     * @param start 起始索引
     * @param end   结束索引
     * @param <T>   泛型
     * @return 截取后的数组
     */
    public static <T> T[] sub(T[] arr, int start, int end) {
        if (null == arr || arr.length < 1) {
            throw new UtilException(CodeResultEnum.NULL_FAILURE);
        }
        if (start < 0) {
            start = 0;
        }
        end += 1;
        if (end > arr.length) {
            end = arr.length;
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        if (start == end) {
            return newArray(arr, 0);
        }
        return Arrays.copyOfRange(arr, start, end);
    }

    /**
     * 截取数组
     *
     * @param arr 数组
     * @param end 结束位置
     * @param <T> 泛型
     * @return 截取后的数组
     */
    public static <T> T[] sub(T[] arr, int end) {
        return sub(arr, ComConstant.ZERO, end);
    }

    // sub操作end

    // remove操作start

    /**
     * 删除数组中元素，根据值
     *
     * @param arr 数组
     * @param obj 元素值
     * @param <T> 泛型
     * @return 删除后的数组
     */
    public static <T> T[] remove(T[] arr, Object obj) {
        if (isEmpty(arr)) {
            return null;
        }
        if (indexOf(arr, obj) > INDEX_NOT_FOUNT) {
            int index = indexOf(arr, obj);
            return remove(remove(arr, index), obj);
        }
        return arr;
    }

    /**
     * 根据索引删除数组元素
     *
     * @param arr   数组
     * @param index 索引
     * @param <T>   泛型
     * @return 删除后的数组
     */
    public static <T> T[] remove(T[] arr, int index) {
        if (isEmpty(arr)) {
            return null;
        }
        if (index > arr.length - 1 || index < 0) {
            return arr;
        }
        T[] rst = newArray(arr, arr.length - 1);
        System.arraycopy(arr, 0, rst, 0, index);
        System.arraycopy(arr, index + 1, rst, index, arr.length - index - 1);
        return rst;
    }

    // remove操作end
    // reverse反转数组start

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static <T> void reverse(T[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        T temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static void reverse(int[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static void reverse(short[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        short temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static void reverse(byte[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        byte temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static void reverse(long[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        long temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static void reverse(float[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        float temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static void reverse(double[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        double temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 反转数组
     * 改变原本数组
     *
     * @param arr 数组
     */
    public static void reverse(char[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        char temp;
        for (int i = 0; i < arr.length / ComConstant.TWO; i++) {
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

    // reverse数组反转end

    // distinct 去重 start

    /**
     * 数组去重
     *
     * @param t   数组
     * @param <T> 泛型
     * @return 去重后的数组
     */
    public static <T> T[] distinct(T[] t) {
        if (isEmpty(t)) {
            return newArray(t, 0);
        }
        Set<T> set = new HashSet<>();
        Collections.addAll(set, t);
        return set.toArray(newArray(t, set.size()));
    }

    // distinct 去重 end


    // 数组操作end -----------------------------
}
