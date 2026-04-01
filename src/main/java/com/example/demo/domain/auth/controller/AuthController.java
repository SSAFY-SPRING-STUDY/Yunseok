package com.example.demo.domain.auth.controller;

import com.example.demo.domain.auth.component.SessionManager;
import com.example.demo.domain.auth.controller.dto.LoginRequest;
import com.example.demo.domain.auth.controller.dto.LoginResponse;
import com.example.demo.domain.auth.service.AuthService;
import com.example.demo.domain.member.controller.dto.MemberResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final SessionManager sessionManager;
  private final AuthService authService;

  @PostMapping("/login")
  public LoginResponse login(
      HttpServletResponse response,
      @RequestBody LoginRequest request
  ) {
    log.info("POST /api/auth/login");
    MemberResponse target = authService.login(request);
    if (target == null) {
      throw new IllegalArgumentException("일치하는 회원 없음.");
    }
    String uuid = sessionManager.createSession(target.id(), response);
    log.info("login created uuid={}", uuid);
    return LoginResponse.of(uuid);
  }

  @PostMapping("/logout")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void logout(
      @RequestHeader("Authorization") String authHeader
  ) {
    log.info("POST /api/auth/logout authHeader={}", authHeader);
    sessionManager.deleteSession(authHeader);
  }

}
