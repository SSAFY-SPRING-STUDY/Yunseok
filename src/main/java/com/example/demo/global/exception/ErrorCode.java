package com.example.demo.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  // 요청(400)
  INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "잘못된 요청 파라미터입니다."),

  // 인증(401)
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요한 서비스입니다."),

  //본인 글이 아닌데 수정/삭제 시도(403)
  INVALID_PERMISSION(HttpStatus.FORBIDDEN, "해당 권한이 없습니다."),

  // 회원(404)
  MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),

  // 게시글(404)
  POST_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."),

  // 서버(500)
  INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부에 오류가 발생했습니다.");

  private final HttpStatus status;
  private final String message;
}