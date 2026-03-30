package com.example.demo.controller.dto;

import com.example.demo.domain.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class PostResponse {

  private final Long id;
  private final String title;
  private final String content;
  private final String author;

  public static PostResponse from(PostEntity post) {
    return new PostResponse(
        post.getId(),
        post.getTitle(),
        post.getContent(),
        post.getAuthor()
    );
  }
}
