package com.i2silly.common.util;

import com.i2silly.common.constant.CodeResultEnum;
import com.i2silly.common.exception.UtilException;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

/**
 * 常用工具类
 *
 * @author hanhan
 * @version 1.0
 */
public class CommonUtil {

    /**
     * 判断对象是否为空
     *
     * @param obj 集合
     * @return 空 true | 不为空 false
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return 0 == ((String) obj).length();
        }
        if (obj instanceof Collection) {
            return 0 == ((Collection) obj).size();
        }
        if (obj instanceof Map) {
            return 0 == ((Map) obj).size();
        }
        if (obj instanceof Dictionary) {
            return 0 == ((Dictionary) obj).size();
        }
        if (obj.getClass().isArray()) {
            return 0 == Array.getLength(obj);
        }
        return false;
    }

    /**
     * 判断对象不为空
     *
     * @param obj 对象
     * @return 不为空true | 空false
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 获取对象规范名称
     *
     * @param obj 对象
     * @return 规范名称
     */
    public static String getCanonicalName(Object obj) {
        if (obj == null) {
            throw new UtilException(CodeResultEnum.NULL_FAILURE);
        }
        return obj.getClass().getCanonicalName();
    }


}
