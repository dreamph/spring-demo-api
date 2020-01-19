package com.dreamph.apps.core.dto;

import lombok.Data;

@Data
public class DataResponse<T> {
    private boolean status;
    private T data;

    public DataResponse() {
    }

    public DataResponse(boolean status) {
        this.status = status;
    }

    public DataResponse(boolean status, T data) {
        this.status = status;
        this.data = data;
    }
}
