package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import java.util.ArrayList;
import java.util.List;
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
        posts.remove(post);
        return;
      }
    }
  }

}
