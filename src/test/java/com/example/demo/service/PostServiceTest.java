package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.example.demo.controller.dto.PostRequest;
import com.example.demo.controller.dto.PostResponse;
import com.example.demo.domain.PostEntity;
import com.example.demo.repository.PostRepostiory;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostServiceTest {

  private PostService postService;
  private PostRepostiory postRepostiory;

  @BeforeEach
  void setUp() throws Exception {
    resetAutoIncrement();
    postRepostiory = new PostRepostiory();
    postService = new PostService(postRepostiory);
  }

  @Test
  void saveAndFindAll() {
    PostResponse savedPost = postService.save(createRequest("title-1", "content-1", "author-1"));

    List<PostResponse> posts = postService.findAll();

    assertEquals(1L, savedPost.getId());
    assertEquals(1, posts.size());
    assertEquals("title-1", posts.get(0).getTitle());
    assertEquals("content-1", posts.get(0).getContent());
    assertEquals("author-1", posts.get(0).getAuthor());
  }

  @Test
  void findById() {
    postService.save(createRequest("title-1", "content-1", "author-1"));

    PostResponse foundPost = postService.findById(1L);

    assertEquals(1L, foundPost.getId());
    assertEquals("title-1", foundPost.getTitle());
    assertEquals("content-1", foundPost.getContent());
    assertEquals("author-1", foundPost.getAuthor());
  }

  @Test
  void update() {
    postService.save(createRequest("title-1", "content-1", "author-1"));

    postService.update(1L, createRequest("title-2", "content-2", "author-2"));

    PostResponse updatedPost = postService.findById(1L);
    assertEquals("title-2", updatedPost.getTitle());
    assertEquals("content-2", updatedPost.getContent());
    assertEquals("author-2", updatedPost.getAuthor());
  }

  @Test
  void delete() {
    postService.save(createRequest("title-1", "content-1", "author-1"));

    postService.delete(1L);

    assertEquals(0, postService.findAll().size());
    assertNull(postRepostiory.findById(1L));
  }

  private PostRequest createRequest(String title, String content, String author) {
    PostRequest request = new PostRequest();
    request.setTitle(title);
    request.setContent(content);
    request.setAuthor(author);
    return request;
  }

  private void resetAutoIncrement() throws Exception {
    Field autoIncrementField = PostEntity.class.getDeclaredField("AUTO_INCREMENT");
    autoIncrementField.setAccessible(true);
    autoIncrementField.setLong(null, 1L);
  }
}
