package com.example.demo.controller.dto;

import com.example.demo.domain.PostEntity;

public record PostResponse(Long id, String title, String content, String author) {

  public static PostResponse from(PostEntity post) {
    return new PostResponse(
        post.getId(),
        post.getTitle(),
        post.getContent(),
        post.getAuthor()
    );
  }
}
