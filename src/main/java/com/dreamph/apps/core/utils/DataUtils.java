package com.dreamph.apps.core.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;


public class DataUtils {
    public static boolean isEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> list) {
        return !isEmpty(list);
    }

    public static int getSize(Collection<?> list) {
        return isEmpty(list) ? 0 : list.size();
    }

    public static void destroyObject(Object object) {
        if (object != null) {
            if (object instanceof Collection<?>) {
                ((Collection) object).clear();
            } else if (object instanceof Map<?, ?>) {
                ((Map) object).clear();
            }
            object = null;
        }
    }

    public static boolean getValue(Boolean value, boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public static BigDecimal getValue(BigDecimal value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public static String getValue(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }
}
