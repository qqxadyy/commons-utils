/*
 * Copyright © 2021 pengjianqiang
 * All rights reserved.
 * 项目名称：pjq-commons-utils
 * 项目描述：pjq-commons-utils
 * 项目地址：https://github.com/qqxadyy/pjq-commons-utils
 * 许可证信息：见下文
 *
 * ======================================================================
 *
 * The MIT License
 * Copyright © 2021 pengjianqiang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pjq.commons.utils;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 字符串、集合的判断工具类
 * <p>
 * Create at 2019年1月15日
 * 
 * @author pengjianqiang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckUtils {
    public static boolean isEmpty(String s) {
        String invisibleChar = "\u200b|\u200B"; // 该字符串是不可见的，控制台等打印不出，但是有实际长度
        String ns = null == s ? null : new String(s).trim().replaceAll(invisibleChar, "");
        return StringUtils.isBlank(ns) || "null".equalsIgnoreCase(ns) || "undefined".equalsIgnoreCase(ns);
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean areEmpty(String... ss) {
        if (ArrayUtils.isEmpty(ss)) {
            return true;
        } else {
            for (String s : ss) {
                if (!isEmpty(s)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean areNotEmpty(String... ss) {
        if (ArrayUtils.isEmpty(ss)) {
            return false;
        } else {
            for (String s : ss) {
                if (isEmpty(s)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Object[] array) {
        if (array instanceof String[]) {
            return areEmpty((String[])array);
        } else {
            return ArrayUtils.isEmpty(array);
        }
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static boolean isNull(Object obj) {
        return null == obj;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     * 判断字符串不能为空
     * 
     * @param s
     *            要判断的字符串
     * @param msg
     */
    public static void checkNotEmpty(String s, String msg) {
        if (isEmpty(s)) {
            throw new RuntimeException(msg);
        }
    }

    public static void checkNotNull(Object obj, String msg) {
        if (isNull(obj)) {
            throw new RuntimeException(msg);
        }
    }

    public static void checkNotEmpty(Collection<?> collection, String msg) {
        if (isEmpty(collection)) {
            throw new RuntimeException(msg);
        }
    }

    public static void checkNotEmpty(Map<?, ?> map, String msg) {
        if (isEmpty(map)) {
            throw new RuntimeException(msg);
        }
    }

    public static void checkNotEmpty(Object[] array, String msg) {
        if (isEmpty(array)) {
            throw new RuntimeException(msg);
        }
    }

    public static void checkNotFalse(boolean bval, String msg) {
        if (!bval) {
            throw new RuntimeException(msg);
        }
    }

    public static void checkNotTrue(boolean bval, String msg) {
        if (bval) {
            throw new RuntimeException(msg);
        }
    }
}