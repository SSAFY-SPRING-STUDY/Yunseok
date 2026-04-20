package com.example.demo.domain.member.controller;

import com.example.demo.domain.auth.component.SessionManager;
import com.example.demo.domain.member.controller.dto.MemberRequest;
import com.example.demo.domain.member.controller.dto.MemberResponse;
import com.example.demo.domain.member.service.MemberService;
import com.example.demo.global.exception.BusinessException;
import com.example.demo.global.exception.ErrorCode;
import com.example.demo.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

  private final SessionManager sessionManager;
  private final MemberService memberService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ApiResponse<MemberResponse> createMember(
      @RequestBody MemberRequest request) {
    return ApiResponse.success("회원가입 되었습니다.", memberService.createMember(request));
  }

  @GetMapping("/me")
  public ApiResponse<MemberResponse> findme(
      @RequestHeader("Authorization") String authHeader
  ) {
    Long id = sessionManager.find(authHeader);
    if (id == null) {
      throw new BusinessException(ErrorCode.UNAUTHORIZED);
    }
    return ApiResponse.success("내 정보 조회.", memberService.findme(id));
  }

}
