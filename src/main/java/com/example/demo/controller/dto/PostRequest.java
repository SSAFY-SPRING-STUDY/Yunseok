package com.example.demo.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class PostRequest {

  private String title;
  private String content;
  private String author;
}
