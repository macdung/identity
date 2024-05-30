package com.dmd.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTED(1001,"userExisted", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005,"userNotExisted",HttpStatus.NOT_FOUND),
    INVALID_USERNAME(1002,"invalidUsername",HttpStatus.BAD_REQUEST),
    UNCATEGORIZED_EXCEPTION(9999, "uncategorizedException",HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHENTICATED(1006,"unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1011,"unauthenticated",HttpStatus.FORBIDDEN);

    private int code;
    private String message;
    private HttpStatus statusCode;
}
