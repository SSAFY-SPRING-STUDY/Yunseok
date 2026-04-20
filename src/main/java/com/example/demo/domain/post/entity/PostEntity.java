package com.example.demo.domain.post.entity;

import com.example.demo.domain.post.controller.dto.PostRequest;
import lombok.Getter;

@Getter
public class PostEntity {

  private static Long AUTO_INCREMENT = 1L;

  private final Long id;
  private String title;
  private String content;
  private Long authorId;

  public PostEntity(String title, String content, Long authorId) {
    id = AUTO_INCREMENT++;
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }

  public static PostEntity from(PostRequest request) {
    return new PostEntity(request.title(), request.content(), request.authorId());
  }

  public static PostEntity of(String title, String content, Long authorId) {
    return new PostEntity(title, content, authorId);
  }

  public void update(String title, String content, Long authorId) {
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }
}
