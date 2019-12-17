package com.rookie.common.filter;

/**
 * 数组过滤接口
 *
 * @author i2silly
 * @date 2019/12/17
 */
public interface ComFilter<T>{

    /**
     * 过滤
     *
     * @param t 泛型参数
     * @return 返回对象
     */
    boolean filter(T t);
}
