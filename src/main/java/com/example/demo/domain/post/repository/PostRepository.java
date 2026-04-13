package com.example.demo.domain.post.repository;

import com.example.demo.domain.post.entity.PostEntity;
import com.example.demo.global.exception.BusinessException;
import com.example.demo.global.exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

  private final List<PostEntity> posts = new ArrayList<>();

  public PostEntity save(PostEntity entity) {
    posts.add(entity);
    return entity;
  }

  public List<PostEntity> findAll() {
    return List.copyOf(posts);
  }

  public Optional<PostEntity> findById(long id) {
    return posts.stream()
        .filter(postEntity -> postEntity.getId().equals(id))
        .findAny();
  }

  public void deleteById(Long id) {
    PostEntity post = posts.stream()
        .filter(postEntity -> postEntity.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));
    posts.remove(post);
  }

}
