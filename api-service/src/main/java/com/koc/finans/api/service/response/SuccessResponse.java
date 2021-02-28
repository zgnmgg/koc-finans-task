package com.koc.finans.api.service.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SuccessResponse extends Response {

    private SuccessResponse() {
        super();
    }

    public SuccessResponse(String message) {
        super(HttpStatus.OK, message);
    }
}
