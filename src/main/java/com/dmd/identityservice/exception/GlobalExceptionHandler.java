package com.dmd.identityservice.exception;

import com.dmd.identityservice.dto.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<APIResponse> handlingException(Exception e){

        APIResponse response = new APIResponse<>();
        response.setCode(9999);
        response.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<APIResponse> handlingAppException(AppException e){
        APIResponse response = new APIResponse<>();
        response.setCode(e.getErrorCode().getCode());
        response.setMessage(e.getErrorCode().getMessage());
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingValidateException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
    }
}
