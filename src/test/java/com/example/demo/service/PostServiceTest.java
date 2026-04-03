package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demo.domain.post.controller.dto.PostRequest;
import com.example.demo.domain.post.controller.dto.PostResponse;
import com.example.demo.domain.post.entity.PostEntity;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.post.service.PostService;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostServiceTest {

  private PostService postService;
  private PostRepository postRepository;

  @BeforeEach
  void setUp() throws Exception {
    resetAutoIncrement();
    postRepository = new PostRepository();
    postService = new PostService(postRepository);
  }

  @Test
  void saveAndFindAll() {
    PostResponse savedPost = postService.save(createRequest("title-1", "content-1", "author-1"));

    List<PostResponse> posts = postService.findAll();

    assertEquals(1L, savedPost.id());
    assertEquals(1, posts.size());
    assertEquals("title-1", posts.getFirst().title());
    assertEquals("content-1", posts.getFirst().content());
    assertEquals("author-1", posts.getFirst().author());
  }

  @Test
  void findById() {
    postService.save(createRequest("title-1", "content-1", "author-1"));

    PostResponse foundPost = postService.findById(1L);

    assertEquals(1L, foundPost.id());
    assertEquals("title-1", foundPost.title());
    assertEquals("content-1", foundPost.content());
    assertEquals("author-1", foundPost.author());
  }

  @Test
  void update() {
    postService.save(createRequest("title-1", "content-1", "author-1"));

    postService.update(1L, createRequest("title-2", "content-2", "author-2"));

    PostResponse updatedPost = postService.findById(1L);
    assertEquals("title-2", updatedPost.title());
    assertEquals("content-2", updatedPost.content());
    assertEquals("author-2", updatedPost.author());
  }

  @Test
  void delete() {
    postService.save(createRequest("title-1", "content-1", "author-1"));

    postService.delete(1L);

    assertEquals(0, postService.findAll().size());
    assertTrue(postRepository.findById(1L).isEmpty());
  }

  private PostRequest createRequest(String title, String content, String author) {
    return new PostRequest(title, content, author);
  }

  private void resetAutoIncrement() throws Exception {
    Field autoIncrementField = PostEntity.class.getDeclaredField("AUTO_INCREMENT");
    autoIncrementField.setAccessible(true);
    autoIncrementField.set(null, 1L);
  }
}
