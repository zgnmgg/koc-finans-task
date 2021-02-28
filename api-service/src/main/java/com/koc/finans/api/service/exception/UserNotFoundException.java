package com.koc.finans.api.service.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeExceptionImp {
    private static final long serialVersionUID = 7242012170266538130L;

    @Override
    public String getMessageKey() {
        return "USER.notFound";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public UserNotFoundException() {
        super();
    }
}
