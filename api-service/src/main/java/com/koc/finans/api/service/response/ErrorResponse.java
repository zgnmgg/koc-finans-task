package com.koc.finans.api.service.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ErrorResponse extends Response {
    private List<String> errors;
    private int code = 100;

    private ErrorResponse() {
        super();
    }

    public ErrorResponse(HttpStatus status, String message) {
        super(status, message);
        this.errors = Collections.singletonList(message);
    }

    public ErrorResponse(HttpStatus status, String message, int code) {
        super(status, message);
        this.errors = Collections.singletonList(message);
        this.code = code;
    }

    public ErrorResponse(HttpStatus status, String message, List<String> errors) {
        this(status, message);
        this.errors = errors;
    }

    public ErrorResponse(HttpStatus status, String message, List<String> errors, int code) {
        this(status, message, code);
        this.errors = errors;
    }

    public ErrorResponse(HttpStatus status, String message, String error) {
        this(status, message, Collections.singletonList(error));
    }

    public ErrorResponse(HttpStatus status, String message, String error, int code) {
        this(status, message, Collections.singletonList(error), code);
    }
}
