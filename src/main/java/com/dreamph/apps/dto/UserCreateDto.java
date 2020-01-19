package com.dreamph.apps.dto;

import lombok.Data;

import java.io.Serializable;


public class UserCreateDto {
    @Data
    public static class UserCreateRequest implements Serializable {

        private String idCardNo;
        private String loginName;
        private String loginPassword;
        private String firstName;
        private String lastName;

        private String userTxBy;
    }
}
