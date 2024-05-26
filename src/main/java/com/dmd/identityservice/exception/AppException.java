package com.dmd.identityservice.exception;

import lombok.Data;

@Data
public class AppException extends RuntimeException{
    private ErrorCode errorCode;
}
