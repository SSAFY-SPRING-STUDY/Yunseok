package com.example.demo.domain.auth.component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {

  private static final String BEARER_PREFIX = "Bearer ";
  private final Map<String, Long> sessionStore = new ConcurrentHashMap<>();

  public String createSession(Long id) {
    String uuid = String.valueOf(UUID.randomUUID());
    sessionStore.put(uuid, id);
    return uuid;
  }

  public void deleteSession(String authHeader) {
    String uuid = extractToken(authHeader);
    sessionStore.remove(uuid);
  }

  public Long find(String authHeader) {
    String uuid = extractToken(authHeader);
    return sessionStore.get(uuid);
  }

  private String extractToken(String authHeader) {
    if (!StringUtils.hasText(authHeader) || !authHeader.startsWith(BEARER_PREFIX)) {
      return null;
    }
    return authHeader.substring(BEARER_PREFIX.length());
  }
}
