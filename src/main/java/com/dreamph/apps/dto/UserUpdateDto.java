package com.dreamph.apps.dto;

import lombok.Data;

import java.io.Serializable;


public class UserUpdateDto {
    @Data
    public static class UserUpdateRequest implements Serializable {

        private String id;

        private String idCardNo;
        private String firstName;
        private String lastName;

        private String userTxBy;
    }
}
