package com.koc.finans.api.service.exception;

import org.springframework.http.HttpStatus;

public abstract class RuntimeExceptionImp extends RuntimeException {
    private static final long serialVersionUID = 6486297553630584955L;

    abstract public String getMessageKey();
    abstract public HttpStatus getHttpStatus();

    public int getErrorCode() {
        return 100;
    }

    public RuntimeExceptionImp() {
        super();
    }

    public RuntimeExceptionImp(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RuntimeExceptionImp(final String message) {
        super(message);
    }

    public RuntimeExceptionImp(final Throwable cause) {
        super(cause);
    }
}
