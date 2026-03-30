package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class PostEntity {

  static private long AUTO_INCREMENT = 1L;

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

  public void update(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
