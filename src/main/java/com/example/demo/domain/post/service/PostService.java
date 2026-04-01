package com.example.demo.domain.post.service;

import com.example.demo.domain.post.controller.dto.PostRequest;
import com.example.demo.domain.post.controller.dto.PostResponse;
import com.example.demo.domain.post.entity.PostEntity;
import com.example.demo.domain.post.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public PostResponse save(PostRequest request) {
    PostEntity savePost = PostEntity.of(request.title(), request.content(), request.author());
    return PostResponse.from(postRepository.save(savePost));
  }

  public List<PostResponse> findAll() {
    return postRepository.findAll().stream()
        .map(PostResponse::from)
        .toList();
  }

  public PostResponse findById(long userId) {
    PostEntity findPost = postRepository.findById(userId);
    return PostResponse.from(findPost);
  }

  public void update(long userId, PostRequest request) {
    PostEntity targetPost = postRepository.findById(userId);
    targetPost.update(request.title(), request.content(), request.author());
  }

  public void delete(long id) {
    postRepository.deleteById(id);
  }
}
