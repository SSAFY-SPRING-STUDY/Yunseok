package com.example.demo.service;

import com.example.demo.controller.dto.PostRequest;
import com.example.demo.controller.dto.PostResponse;
import com.example.demo.domain.PostEntity;
import com.example.demo.repository.PostRepostiory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepostiory postRepostiory;

  public PostResponse save(PostRequest request) {
    PostEntity savedPost = postRepostiory.save(request);
    return PostResponse.from(savedPost);
  }

  public List<PostResponse> findAll() {
    return postRepostiory.findAll().stream()
        .map(PostResponse::from)
        .toList();
  }

  public PostResponse findById(long userId) {
    PostEntity findPost = postRepostiory.findById(userId);
    return PostResponse.from(findPost);
  }

  public void update(long userId, PostRequest request) {
    PostEntity updatePost = postRepostiory.save(userId, request);
    updatePost.update(request.getTitle(), request.getContent(), request.getAuthor());
  }

  public void delete(long id) {
    postRepostiory.deleteById(id);
  }
}
