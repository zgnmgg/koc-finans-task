package com.koc.finans.api.service.exception;

import org.springframework.http.HttpStatus;

public class IncomeNotFoundException extends RuntimeExceptionImp {
    private static final long serialVersionUID = -9021945199749966199L;

    @Override
    public String getMessageKey() {
        return "INCOME.notFound";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public IncomeNotFoundException() {
        super();
    }
}
