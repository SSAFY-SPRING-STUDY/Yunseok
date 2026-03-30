package com.example.demo.repository;

import com.example.demo.controller.dto.PostRequest;
import com.example.demo.domain.PostEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class PostRepostiory {

  private final List<PostEntity> posts = new ArrayList<>();

  public PostEntity save(PostRequest request) {
    PostEntity post = new PostEntity(
        request.getTitle(),
        request.getContent(),
        request.getAuthor()
    );
    log.info("repository, save={}", post);
    posts.add(post);
    return post;
  }

  public PostEntity save(Long id, PostRequest request) {
    PostEntity post = new PostEntity(
        id,
        request.getTitle(),
        request.getContent(),
        request.getAuthor()
    );
    log.info("repository, save={}", post);
    posts.add(post);
    return post;
  }

  public List<PostEntity> findAll() {
    return List.copyOf(posts);
  }

  public PostEntity findById(long userId) {

    for (PostEntity post : posts) {
      if (post.getId() == userId) return post;
    }

    return null;
  }

  public void deleteById(long id) {

    PostEntity p = null;

    for (PostEntity post : posts) {
      if (post.getId() == id) {
        p = post;
        break;
      }
    }

    if (p == null) return;
    posts.remove(p);
  }
}
