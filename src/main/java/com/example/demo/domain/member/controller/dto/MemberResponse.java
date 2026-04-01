package com.example.demo.domain.member.controller.dto;

import com.example.demo.domain.member.entity.MemberEntity;

public record MemberResponse(Long id, String loginId, String name) {

  public static MemberResponse from(MemberEntity e) {
    return new MemberResponse(e.getId(), e.getLoginId(), e.getName());
  }
}
