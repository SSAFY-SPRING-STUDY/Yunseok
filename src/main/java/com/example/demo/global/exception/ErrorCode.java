package com.example.demo.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  // 인증
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증되지 않은 사용자입니다"),

  // 회원
  MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "일치하는 회원 없음"),

  // 게시글
  POST_NOT_FOUND(HttpStatus.NOT_FOUND, "일치하는 게시글 없음"),

  // 요청
  INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),

  // 서버
  INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류");

  private final HttpStatus status;
  private final String message;
}