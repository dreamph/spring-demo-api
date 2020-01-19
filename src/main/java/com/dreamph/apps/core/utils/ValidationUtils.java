package com.dreamph.apps.core.utils;


import com.dreamph.apps.core.exception.ValidationException;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

public class ValidationUtils {

    private static boolean isNullOrEmpty(Object value) {
        if (value == null) {
            return true;
        }
        if (value instanceof String) {
            return StringUtils.isEmpty((String) value);
        }
        return false;
    }

    public static boolean isNotEmpty(Object value) {
        return !isNullOrEmpty(value);
    }

    public static boolean isNotEmptyAll(Object... values) {
        for (Object value : values) {
            if (isNullOrEmpty(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(Object value) {
        return isNullOrEmpty(value);
    }

    public static boolean isBetween(BigDecimal value, BigDecimal value1, BigDecimal value2) {
        return (value.compareTo(value1) >= 0 && value.compareTo(value2) <= 0);
    }

    public static boolean isNotBetween(BigDecimal value, BigDecimal value1, BigDecimal value2) {
        return !isBetween(value, value1, value2);
    }

    public static void requiredNotWhen(boolean result, MessageCode errorCode, String... errorMessage) throws ValidationException {
        if (!result) {
            String finalMessage = MessageUtils.buildMessage(errorCode, errorMessage);
            throw new ValidationException(finalMessage);
        }
    }

    public static void requiredNotWhen(boolean result, String errorCode, String... errorMessage) throws ValidationException {
        if (!result) {
            String finalMessage = MessageUtils.buildMessage(errorCode, errorMessage);
            throw new ValidationException(finalMessage);
        }
    }

    public static void validate(List<String> allErrors, boolean result, MessageCode errorCode, String... errorMessage) {
        if (!result) {
            String finalMessage = MessageUtils.buildMessage(errorCode, errorMessage);
            allErrors.add(finalMessage);
        }
    }

    /*
    public static void requiredNotWhen(boolean result, MessageCode errorCode, String... errorMessage) throws ValidationException {
        requiredNotWhen(result, errorCode.getCode(), errorMessage);
    }

    public static void requiredNotWhen(boolean result, String errorCode, String... errorMessage) throws ValidationException {
        if (!result) {
            if (errorMessage == null) {
                throw new ValidationException(errorCode + " : " + MessageUtils.getMessage(errorCode));
            } else {
                throw new ValidationException(errorCode + " : " + MessageUtils.getMessage(errorCode, errorMessage));
            }
        }
    }
    */
}
