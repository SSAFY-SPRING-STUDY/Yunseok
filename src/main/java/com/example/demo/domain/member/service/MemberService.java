package com.example.demo.domain.member.service;

import com.example.demo.domain.member.controller.dto.MemberRequest;
import com.example.demo.domain.member.controller.dto.MemberResponse;
import com.example.demo.domain.member.entity.MemberEntity;
import com.example.demo.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberResponse createMember(MemberRequest request) {
    MemberEntity e = MemberEntity.from(request);
    memberRepository.save(e);
    return MemberResponse.from(e);
  }

  public MemberResponse findme() {
    return null;
  }
}
