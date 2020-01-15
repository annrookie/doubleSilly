package com.i2silly.common.util;

import com.i2silly.common.constant.CodeResultEnum;
import com.i2silly.common.constant.ComConstant;
import com.i2silly.common.exception.UtilException;
import jdk.nashorn.internal.ir.CallNode;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author hanhan
 * @version 1.0
 */
public class CollectionUtil {

    // list集合操作 start

    /**
     * list 剔重
     *
     * @param list list集合
     * @param <T>  泛型
     * @return 去重完list
     */
    public static <T> List<T> distinct(List<T> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    /**
     * list集合合并
     *
     * @param a   第一个集合
     * @param b   第二个集合
     * @param <T> 泛型
     * @return 合并后的集合
     */
    public static <T> List<T> add(List<T> a, List<T> b) {
        List<T> result = new ArrayList<>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 获取交集
     *
     * @param a   第一个集合
     * @param b   第二个集合
     * @param <T> 泛型
     * @return 交集
     */
    public static <T> List<T> intersection(List<T> a, List<T> b) {
        List<T> result = new ArrayList<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 两个集合不同的元素
     *
     * @param superset 超集
     * @param subset   子集
     * @param <T>      泛型
     * @return 两个集合不同的元素
     */
    public static <T> List<T> difference(List<T> superset, List<T> subset) {
        List<T> result = new ArrayList<>(superset);
        result.removeAll(subset);
        return result;
    }

    /**
     * 获取除交集外的所有元素
     *
     * @param a   第一个集合
     * @param b   第二个集合
     * @param <T> 泛型
     * @return 除交集外的元素
     */
    public static <T> List<T> complement(List<T> a, List<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    /**
     * 并集
     *
     * @param a   第一个list
     * @param b   第二个list
     * @param <T> 泛型
     * @return 并集
     */
    public static <T> List<T> union(List<T> a, List<T> b) {
        return distinct(add(a, b));
    }

    /**
     * 将List &gt;Map&lt; 根据Map中的键进行分组
     *
     * @param list 需要分组的list
     * @param keys 分组的键
     * @param <V>  值泛型
     * @return 分完组的Map
     */
    public static <V> Map<String, List<Map<String, V>>> listDivide(List<Map<String, V>> list, String[] keys) {
        if (isEmpty(list)) {
            return null;
        }
        Map<String, List<Map<String, V>>> rstMap = new HashMap<>();
        if (keys == null || keys.length < 1) {
            rstMap.put("default", list);
            return rstMap;
        }
        List<Map<String, V>> ml;
        for (Map<String, V> map : list) {
            StringBuilder sb = new StringBuilder();
            for (String key : keys) {
                if (null != map.get(key)) {
                    sb.append(map.get(key));
                }
            }
            String k = CommonUtil.isEmpty(sb) ? "empty" : sb.toString();
            ml = rstMap.get(k) == null ? new ArrayList<>() : rstMap.get(k);
            ml.add(map);
            rstMap.put(k, ml);
        }
        return rstMap;
    }

    /**
     * 将ListBean 根据javaBean中的属性进行分组
     *
     * @param listBean 需要分组的list
     * @param keys     分组的键
     * @param <T>      javaBean
     * @return 分完组的Map
     */
    public static <T> Map<String, List<T>> listBeanDivide(List<T> listBean, String[] keys) {
        if (isEmpty(listBean)) {
            throw new UtilException(CodeResultEnum.NULL_FAILURE);
        }
        T t = listBean.get(0);
        Field[] fields = t.getClass().getDeclaredFields();
        if (CommonUtil.isEmpty(fields)) {
            throw new UtilException(CodeResultEnum.PARAM_FAILURE);
        }
        Set<String> set = new HashSet<>();
        Map<String, Field> fieldMap = new HashMap<>();
        for (Field field : fields) {
            set.add(field.getName());
            fieldMap.put(field.getName(), field);
        }
        for (String key : keys) {
            if (!set.contains(key)) {
                throw new UtilException(CodeResultEnum.PARAM_FAILURE);
            }
        }
        Map<String, List<T>> rstMap = new HashMap<>();
        if (keys.length < 1) {
            rstMap.put("default", listBean);
            return rstMap;
        }
        try {
            List<T> ml;
            for (T javaBean : listBean) {
                StringBuilder sb = new StringBuilder();
                for (String key : keys) {
                    Field field = fieldMap.get(key);
                    field.setAccessible(true);
                    Object o = field.get(javaBean);
                    sb.append(o);
                }
                String k = CommonUtil.isEmpty(sb) ? "empty" : sb.toString();
                ml = rstMap.get(k) == null ? new ArrayList<>() : rstMap.get(k);
                ml.add(javaBean);
                rstMap.put(k, ml);
            }
            return rstMap;
        } catch (IllegalAccessException e) {
            throw new UtilException(CodeResultEnum.UNKNOWN_FAILURE);
        }
    }
    // list集合操作end
    //------------------------------------------------------------------------
    //set 集合操作start

    /**
     * set集合合并
     *
     * @param a   第一个集合
     * @param b   第二个集合
     * @param <T> 泛型
     * @return 合并后的集合
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 获取交集
     *
     * @param a   第一个集合
     * @param b   第二个集合
     * @param <T> 泛型
     * @return 交集
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 两个集合不同的元素|差异
     *
     * @param superset 超集
     * @param subset   子集
     * @param <T>      泛型
     * @return 两个集合不同的元素
     */
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    /**
     * 获取除交集外的所有元素
     *
     * @param a   第一个集合
     * @param b   第二个集合
     * @param <T> 泛型
     * @return 除交集外的元素
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    // set集合操作end
    //---------------------------------------------------------------------------
    // collection操作start

    /**
     * 判断是否为空
     *
     * @param coll 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection coll) {
        return null == coll || coll.size() == 0;
    }

    /**
     * 判断是否不为空
     *
     * @param coll 集合
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

    /**
     * 集合以指定的标识拼接
     *
     * @param coll   集合
     * @param format 标识/格式
     * @return 字符串
     */
    public static String join(Collection coll, String format) {
        if (CommonUtil.isEmpty(coll)) {
            return ComConstant.EMPTY_STR;
        }
        Iterator iterator = coll.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(iterator.next());
        while (iterator.hasNext()) {
            sb.append(format);
            sb.append(iterator.next());
        }
        return sb.toString();
    }

    /**
     * 集合以指定标识拼接为字符串
     *
     * @param coll   集合
     * @param prefix 前缀
     * @param suffix 后缀
     * @param format 连接标识
     * @return 字符串
     */
    public static String join(Collection coll, String prefix, String suffix, String format) {
        if (CommonUtil.isEmpty(coll)) {
            return ComConstant.EMPTY_STR;
        }
        String p, s, f;
        p = CommonUtil.isEmpty(prefix) ? ComConstant.EMPTY_STR : prefix;
        s = CommonUtil.isEmpty(suffix) ? ComConstant.EMPTY_STR : suffix;
        f = CommonUtil.isEmpty(format) ? ComConstant.EMPTY_STR : format;
        StringBuilder sb = new StringBuilder();
        for (Object o : coll) {
            sb.append(p).append(o).append(s).append(f);
        }
        return sb.toString().substring(0, sb.length() - format.length());
    }

    // collection操作end
}
