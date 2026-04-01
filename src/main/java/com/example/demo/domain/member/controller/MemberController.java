package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.controller.dto.MemberRequest;
import com.example.demo.domain.member.controller.dto.MemberResponse;
import com.example.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MemberResponse createMember(
      @RequestBody MemberRequest request) {
    return memberService.createMember(request);
  }

  @GetMapping("/me")
  public MemberResponse findme() {
    return memberService.findme();
  }

}
