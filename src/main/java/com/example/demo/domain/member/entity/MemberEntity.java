package com.example.demo.domain.member.entity;

import com.example.demo.domain.member.controller.dto.MemberRequest;
import lombok.Getter;

@Getter
public class MemberEntity {

  private static Long AUTO_INCREMENT = 1L;

  Long id;
  String loginId;
  String password;
  String name;

  private MemberEntity(String loginId, String password, String name) {
    id = AUTO_INCREMENT++;
    this.loginId = loginId;
    this.password = password;
    this.name = name;
  }


  public static MemberEntity from(MemberRequest request) {
    return new MemberEntity(request.loginId(), request.password(), request.name());
  }
}
