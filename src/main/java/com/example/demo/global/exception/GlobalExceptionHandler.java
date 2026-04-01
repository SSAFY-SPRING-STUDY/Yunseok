package com.example.demo.global.exception;


import com.example.demo.global.exception.dto.ErrorDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ErrorDtoResponse noneMember(IllegalArgumentException e) {
    return new ErrorDtoResponse("AUTHORIZED", e.getMessage());
  }


}
