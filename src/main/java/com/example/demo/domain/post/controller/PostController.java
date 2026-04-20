package com.example.demo.domain.post.controller;

import com.example.demo.domain.post.controller.dto.PostRequest;
import com.example.demo.domain.post.controller.dto.PostResponse;
import com.example.demo.domain.post.service.PostService;
import com.example.demo.global.response.ApiResponse;
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
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<List<PostResponse>> findAllPost() {
    log.info("GET /api/posts");
    return ApiResponse.success("게시글 전체 조회.", postService.findAll());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ApiResponse<PostResponse> createPost(
      @RequestBody PostRequest postRequest) {
    log.info("POST /api/posts={}", postRequest);
    return ApiResponse.success("게시글 작성되었습니다.", postService.save(postRequest));
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<PostResponse> findPostById(
      @PathVariable Long id
  ) {
    log.info("GET /api/posts/{}", id);
    return ApiResponse.success("ID로 게시글 조회.", postService.findById(id));
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<Void> updatePost(
      @RequestBody PostRequest request,
      @PathVariable Long id) {
    log.info("PUT /api/posts/{}={}", id, request);
    postService.update(id, request);
    return ApiResponse.success("ID에 해당하는 게시글 업데이트.");
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ApiResponse<Void> deletePost(
      @PathVariable Long id
  ) {
    log.info("DELETE /api/posts/id={}", id);
    postService.delete(id);
    return ApiResponse.success("ID에 해당하는 게시글 삭제.");
  }
}
