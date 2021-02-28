package com.koc.finans.api.service.exception;

import org.springframework.http.HttpStatus;

public class IdentityScoreRequestException extends RuntimeExceptionImp {
    private static final long serialVersionUID = -9021945199749966189L;

    @Override
    public String getMessageKey() {
        return "IDENTITY-SCORE.SERVICE.unreachable";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public IdentityScoreRequestException() {
        super();
    }
}
