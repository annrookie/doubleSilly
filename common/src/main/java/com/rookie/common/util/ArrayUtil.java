package com.rookie.common.util;

import com.rookie.common.constant.ArrayFilter;
import com.rookie.common.constant.ComConstant;

/**
 * 数组工具类
 *
 * @author hanhan
 * @version 1.0
 */
public class ArrayUtil {

    public static final int INDEX_NOT_FOUNT = -1;

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

    // 判空-----------------------------------------------------------------------

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

    public static <T> boolean isNotEmpty(T[] t) {
        return !isEmpty(t);
    }

    public static boolean isNotEmpty(int[] arr) {
        return !isEmpty(arr);
    }

    public static boolean isNotEmpty(short[] arr) {
        return !isEmpty(arr);
    }

    public static boolean isNotEmpty(byte[] arr) {
        return !isEmpty(arr);
    }

    public static boolean isNotEmpty(long[] arr) {
        return !isEmpty(arr);
    }

    public static boolean isNotEmpty(float[] arr) {
        return !isEmpty(arr);
    }

    public static boolean isNotEmpty(double[] arr) {
        return !isEmpty(arr);
    }

    public static boolean isNotEmpty(char[] arr) {
        return !isEmpty(arr);
    }

    public static boolean isNotEmpty(boolean[] arr) {
        return !isEmpty(arr);
    }

    // 拆装包------------------------------------------------------------

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

    // 转为String[]数组------------------------------------------------

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
     * 数字toString方法
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
     * 数组过滤级别
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
}
