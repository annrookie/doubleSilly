package com.i2silly.common.util;

import java.util.*;

/**
 * 创建对象工具类
 *
 * @author hanhan
 * @version 1.0
 */
public class NewUtil {

    /**
     * 创建map集合
     *
     * @param <K> 键
     * @param <V> 值
     * @return hashMap
     */
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    /**
     * 创建带参map集合
     *
     * @param m   map集合
     * @param <K> 键
     * @param <V> 值
     * @return hashMap
     */
    public static <K, V> Map<K, V> map(Map<K, V> m) {
        return new HashMap<>(m);
    }

    /**
     * 创建list集合
     *
     * @param <T> 泛型
     * @return arrayList
     */
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    /**
     * 创建带参list集合
     *
     * @param l   list集合
     * @param <T> 泛型
     * @return arrayList
     */
    public static <T> List<T> list(List<T> l) {
        return new ArrayList<T>(l);
    }

    /**
     * 创建线程安全list集合
     *
     * @param <T> 泛型
     * @return linkedList
     */
    public static <T> List<T> lList() {
        return new LinkedList<T>();
    }

    /**
     * 创建带参线程安全list集合
     *
     * @param l   list集合
     * @param <T> 泛型
     * @return linkedList
     */
    public static <T> List<T> lList(List<T> l) {
        return new LinkedList<T>(l);
    }

    /**
     * 创建Set
     *
     * @param <T> 泛型
     * @return HashSet
     */
    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    /**
     * 创建带参Set
     *
     * @param s   set集合
     * @param <T> 泛型
     * @return HashSet
     */
    public static <T> Set<T> set(Set<T> s) {
        return new HashSet<T>(s);
    }

    /**
     * 创建队列对象
     *
     * @param <T> 泛型
     * @return LinkedList
     */
    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    /**
     * 创建带参队列对象
     *
     * @param q   队列
     * @param <T> 泛型
     * @return LinkedList
     */
    public static <T> Queue<T> queue(Queue<T> q) {
        return new LinkedList<T>(q);
    }
}
