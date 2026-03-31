package com.example.demo.entity;

import lombok.Getter;

@Getter
public class PostEntity {

  private static Long AUTO_INCREMENT = 1L;

  private final Long id;
  private String title;
  private String content;
  private String author;

  public PostEntity(String title, String content, String author) {
    id = AUTO_INCREMENT++;
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public static PostEntity of(String title, String content, String author) {
    return new PostEntity(title, content, author);
  }

  public void update(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
