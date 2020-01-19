package com.dreamph.apps.dto;

import lombok.Data;

import java.io.Serializable;


public class UserDeleteDto {
    @Data
    public static class UserDeleteRequest implements Serializable {

        private String id;
        private String userTxBy;

    }
}
