package com.dreamph.apps.dto;

import com.dreamph.apps.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

public class UserListDto {
    @Data
    public static class UserListRequest implements Serializable {
        private String id;
        private String idCardNo;
    }

    @Data
    public static class UserListResponse {
        private List<User> data;
    }
}
