package com.dreamph.apps.core;

import com.dreamph.apps.core.dto.ErrorDetail;
import com.dreamph.apps.core.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.Optional;


@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetail> handleAllExceptions(Exception ex, WebRequest request) {
        LOG.error(ex.getMessage(), ex);
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErrorDetail errorDetail = getErrorDetail("Internal Error:", ex, request, httpStatus);
        return ResponseEntity.status(httpStatus).body(errorDetail);
    }

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<ErrorDetail> handleApiException(ValidationException ex, WebRequest request) {
        LOG.error(ex.getMessage(), ex);
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        final ErrorDetail errorDetail = getErrorDetail("Validation : ", ex, request, httpStatus);
        return ResponseEntity.status(httpStatus).body(errorDetail);
    }

    @ExceptionHandler(DataAccessException.class)
    public final ResponseEntity<ErrorDetail> handleSQLException(DataAccessException ex, WebRequest request) {
        LOG.error(ex.getMessage(), ex);
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErrorDetail errorDetail = getErrorDetail("SQL Error", null, request, httpStatus);
        return ResponseEntity.status(httpStatus).body(errorDetail);
    }

    private ErrorDetail getErrorDetail(String msg, Throwable ex, WebRequest request, HttpStatus httpStatus) {
        final ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setStatusCode(httpStatus.value());
        errorDetail.setTimestamp(new Date());
        errorDetail.setDetail(request.getDescription(true));
        final StringBuilder errorMessage = new StringBuilder();
        String message = StringUtils.EMPTY;
        if (ex != null) {
            message = Optional.of(ex.getMessage()).orElse(ex.getClass().getSimpleName());
        }
        errorMessage.append(msg);
        errorMessage.append(message);
        errorDetail.setMessage(errorMessage.toString());
        return errorDetail;
    }
}
