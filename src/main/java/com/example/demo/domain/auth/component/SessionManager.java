package com.example.demo.domain.auth.component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {

  private static final String ACCESS_TOKEN = "accessToken";
  private final Map<String, Long> sessionStore = new ConcurrentHashMap<>();

  public String createSession(Long id, HttpServletResponse response) {
    String uuid = String.valueOf(UUID.randomUUID());
    sessionStore.put(uuid, id);

    Cookie cookie = new Cookie(ACCESS_TOKEN, uuid);
    cookie.setPath("/");
    cookie.setSecure(false);
    cookie.setHttpOnly(true);
    response.addCookie(cookie);

    return uuid;
  }

  public void deleteSession(String authHeader) {
    String uuid = authHeader.replace("Bearer ","");
    sessionStore.remove(authHeader);
  }

  public Long find(String authHeader) {
    String uuid = authHeader.replace("Bearer ","");
    return sessionStore.get(uuid);
  }

  private Cookie findCookie(HttpServletRequest request) {
    return Arrays.stream(request.getCookies())
        .filter(cookie -> cookie.getName().equals(ACCESS_TOKEN))
        .findAny()
        .orElse(null);
  }
}
