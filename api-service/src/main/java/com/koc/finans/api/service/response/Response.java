package com.koc.finans.api.service.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Response {

    private String timestamp;
    private HttpStatus status;
    private String message;

    public Response() {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Response(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public Response(HttpStatus status) {
        this();
        this.status = status;
    }
}
