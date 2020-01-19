package com.dreamph.apps.core.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetail {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String detail;
}