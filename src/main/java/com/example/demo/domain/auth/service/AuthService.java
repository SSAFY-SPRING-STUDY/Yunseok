package com.example.demo.domain.auth.service;

import com.example.demo.domain.auth.controller.dto.LoginRequest;
import com.example.demo.domain.member.controller.dto.MemberResponse;
import com.example.demo.domain.member.entity.MemberEntity;
import com.example.demo.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final MemberRepository memberRepository;

  public MemberResponse login(LoginRequest request) {
    MemberEntity member = memberRepository.find(request.loginId(), request.password());
    return MemberResponse.from(member);
  }
}
