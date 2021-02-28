package com.koc.finans.api.service.exception;

import org.springframework.http.HttpStatus;

public class CityScoreRequestException extends RuntimeExceptionImp {
    private static final long serialVersionUID = -9021945199749966199L;

    @Override
    public String getMessageKey() {
        return "CITY-SCORE.SERVICE.unreachable";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public CityScoreRequestException() {
        super();
    }
}
