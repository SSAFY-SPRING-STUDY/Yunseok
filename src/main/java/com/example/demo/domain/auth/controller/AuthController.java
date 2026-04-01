package com.example.demo.domain.auth.controller;

import com.example.demo.domain.auth.controller.dto.LoginRequest;
import com.example.demo.domain.auth.controller.dto.LoginResponse;
import com.example.demo.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;
  @PostMapping("/login")
  public LoginResponse login(
      @RequestBody LoginRequest request) {


    return null;
  }

}
