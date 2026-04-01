package com.example.demo.domain.member.repository;

import com.example.demo.domain.member.entity.MemberEntity;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

  private final ArrayList<MemberEntity> memberList = new ArrayList<>();
  private final Map<UUID, String> memberStore = new ConcurrentHashMap<>();

  public void save(MemberEntity e) {
    memberList.add(e);
  }

  public MemberEntity find(String loginId, String password) {
    return memberList.stream()
        .filter(memberEntity -> memberEntity.getLoginId().equals(loginId) && memberEntity.getPassword().equals(password))
        .findAny()
        .orElse(null);
  }

  public MemberEntity findById(Long id) {
    return memberList.stream()
        .filter(memberEntity -> memberEntity.getId().equals(id))
        .findAny()
        .orElse(null);
  }
}
