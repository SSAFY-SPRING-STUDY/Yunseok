package com.example.demo.domain.auth.service;

import com.example.demo.domain.auth.controller.dto.LoginRequest;
import com.example.demo.domain.member.controller.dto.MemberResponse;
import com.example.demo.domain.member.entity.MemberEntity;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.global.exception.BusinessException;
import com.example.demo.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final MemberRepository memberRepository;

  public MemberResponse login(LoginRequest request) {
    MemberEntity member = memberRepository.find(request.loginId())
        .orElseThrow(() -> new BusinessException(ErrorCode.UNAUTHORIZED));
    if (!member.isSamePassword(request.password())) {
      throw new BusinessException(ErrorCode.UNAUTHORIZED);
    }
    return MemberResponse.from(member);
  }
}
