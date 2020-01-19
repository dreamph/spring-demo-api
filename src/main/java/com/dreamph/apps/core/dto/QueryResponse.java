package com.dreamph.apps.core.dto;

import lombok.Data;

@Data
public class QueryResponse<T> {
    private T data;
    private Long total;
}
