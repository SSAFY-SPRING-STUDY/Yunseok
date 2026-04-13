package com.example.demo.domain.auth.controller.dto;

public record LoginResponse(String accessToken, String tokenType) {

  public static LoginResponse of(String uuid) {
    return new LoginResponse(uuid, "Bearer");
  }
}
