package com.i2silly.common.filter.impl;

import com.i2silly.common.filter.ComFilter;
import com.i2silly.common.util.CommonUtil;

/**
 * <h3>DoubleSilly</h3>
 * <P>空过滤</p>
 *
 * @author i2silly
 * @date 2019/12/17
 */
public class FilterEmpty<T> implements ComFilter<T> {

    /**
     * 空过滤
     *
     * @param o 过滤的参数
     * @return 是|否
     */
    @Override
    public boolean filter(T o) {
        return CommonUtil.isNotEmpty(o);
    }
}
