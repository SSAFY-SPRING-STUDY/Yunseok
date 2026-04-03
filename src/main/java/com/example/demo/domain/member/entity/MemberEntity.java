package com.example.demo.domain.member.entity;

import com.example.demo.domain.member.controller.dto.MemberRequest;
import lombok.Getter;

@Getter
public class MemberEntity {

  private static Long AUTO_INCREMENT = 1L;

  private final Long id;
  private final String loginId;
  private String password;
  private String name;

  private MemberEntity(String loginId, String password, String name) {
    id = AUTO_INCREMENT++;
    this.loginId = loginId;
    this.password = password;
    this.name = name;
  }

  public static MemberEntity from(MemberRequest request) {
    return new MemberEntity(request.loginId(), request.password(), request.name());
  }

  public boolean isSamePassword(String password) {
    return this.password.equals(password);
  }
}
