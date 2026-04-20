package com.example.demo.domain.post.controller.dto;

import com.example.demo.domain.post.entity.PostEntity;

public record PostResponse(Long id, String title, String content, Long authorId) {

  public static PostResponse from(PostEntity post) {
    return new PostResponse(
        post.getId(),
        post.getTitle(),
        post.getContent(),
        post.getAuthorId()
    );
  }
}
