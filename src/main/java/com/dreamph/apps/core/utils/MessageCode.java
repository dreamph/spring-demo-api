package com.dreamph.apps.core.utils;

import java.util.HashMap;
import java.util.Map;

public enum MessageCode {

    //COMMONS MESSAGES
    E00001("E00001", "{0} field is required"),
    E00002("E00002", "{0} field is invalid format"),
    E00003("E00003", "{0} must more than 0"),
    E00004("E00004", "Invalid currency not support"),
    E00005("E00005", "{0} must between 1 and 100"),
    E00006("E00006", "New Password and confirm password mismatch.."),
    E00007("E00007", "Old Password invalid..."),
    E00008("E00008", "Password and confirm password mismatch.."),
    E00009("E00009", "Username [{0}] already registered"),
    E00010("E00010", "Username [{0}] does not exist"),
    E00011("E00011", "{0} Size not more than {1}"),
    E00012("E00012", "{0} field is invalid"),
    E00013("E00013", "{0} field must be {1} characters"),
    E00014("E00014", "{0} field must more than or equal {1} characters"),
    E00015("E00015", "{0} field {1}"),
    E00016("E00016", "{0}"),
    E00017("E00017", "{0} does not exist or status is inactive"),
    //COMMONS MESSAGES

    //CUSTOMER MESSAGES
    E20001("E20001", "Customer not found"),


    E99001("E99001", "System Unavailable"),

    //REPORT MESSAGE
    RE00001("RE00001", "{0} data not found!");


    private static Map<String, String> messages = null;
    private String code;
    private String desc;

    MessageCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static Map<String, String> getMessages() {
        if (messages == null) {
            messages = new HashMap<>();
            for (MessageCode code : values()) {
                messages.put(code.code, code.desc);
            }
        }
        return messages;
    }
}
