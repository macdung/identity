package com.dmd.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTED(1001,"userExisted"),
    INVALID_USERNAME(1002,"invalidUsername"),
    UNCATEGORIZED_EXCEPTION(9999, "uncategorizedException");
    private int code;
    private String message;
}
