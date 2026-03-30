package com.example.demo.controller;

import com.example.demo.controller.dto.PostRequest;
import com.example.demo.controller.dto.PostResponse;
import com.example.demo.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;



  @GetMapping
  public List<PostResponse> findAllPost() {
    log.info("GET /api/posts");
    return postService.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PostResponse createPost(
      @RequestBody PostRequest postRequest) {
    log.info("POST /api/posts={}", postRequest);
    return postService.save(postRequest);
  }

  @GetMapping("/{id}")
  public PostResponse findPostById(
      @PathVariable String id
  ) {
    log.info("GET /api/posts/{}", id);
    long userId = Long.parseLong(id);
    return postService.findById(userId);
  }

  @PutMapping("/{id}")
  public void updatePost(
      @RequestBody PostRequest request,
      @PathVariable("id") Long userId) {
    log.info("PUT /api/posts/{}={}", userId, request);
    postService.update(userId, request);
  }

  @DeleteMapping("/{id}")
  public void deletePost(
      @PathVariable Long id
  ) {
    log.info("DELETE /api/posts/id={}", id);
    postService.delete(id);
  }


}
