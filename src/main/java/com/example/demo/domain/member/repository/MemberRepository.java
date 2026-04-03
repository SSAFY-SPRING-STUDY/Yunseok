package com.example.demo.domain.member.repository;

import com.example.demo.domain.member.entity.MemberEntity;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

  private final Map<Long, MemberEntity> membersById = new ConcurrentHashMap<>();
  private final Map<String, MemberEntity> membersByLoginId = new ConcurrentHashMap<>();

  public void save(MemberEntity e) {
    membersById.put(e.getId(), e);
    membersByLoginId.put(e.getLoginId(), e);
  }

  public Optional<MemberEntity> find(String loginId) {
    return Optional.ofNullable(membersByLoginId.get(loginId));
  }

  public Optional<MemberEntity> findById(Long id) {
    return Optional.ofNullable(membersById.get(id));
  }
}
