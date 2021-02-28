package com.koc.finans.api.service.exception;


import org.springframework.http.HttpStatus;

public class UserExistsException extends RuntimeExceptionImp {
    private static final long serialVersionUID = 7242012170266548130L;

    @Override
    public String getMessageKey() {
        return "USER.exists";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public UserExistsException() {
        super();
    }
}

