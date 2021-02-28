package com.koc.finans.api.service.exception;

import org.springframework.http.HttpStatus;

public class HttpRequestException extends RuntimeExceptionImp {
    private static final long serialVersionUID = -6757293802567226392L;

    @Override
    public String getMessageKey() {
        return "service.unknown";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public HttpRequestException() {
        super();
    }
}
