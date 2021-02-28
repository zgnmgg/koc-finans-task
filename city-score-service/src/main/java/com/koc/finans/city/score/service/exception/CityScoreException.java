package com.koc.finans.city.score.service.exception;

import org.springframework.http.HttpStatus;

public class CityScoreException extends RuntimeExceptionImp {
    private static final long serialVersionUID = -9021945199749966199L;

    @Override
    public String getMessageKey() {
        return "CITY.unknown";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public CityScoreException() {
        super();
    }
}
