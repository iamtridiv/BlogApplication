package com.xofuratech.BlogApplication.controllers;

import com.xofuratech.BlogApplication.payloads.PostDto;
import com.xofuratech.BlogApplication.services.PostService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    // Create
    @PostMapping("/users/{userId}/categories/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId) {
        PostDto createdPost = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // get Posts by User
    @GetMapping("/users/{userId}/posts")
    public  ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
        List<PostDto> posts = postService.getPostsByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // get Posts by Category
    @GetMapping("/categories/{categoryId}/posts")
    public ResponseEntity<?> getPostsByCategory(@PathVariable Integer categoryId) {
        List<PostDto> posts = postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // get All Posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(
                                            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
        List<PostDto> posts = postService.getAllPosts(pageNumber, pageSize);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // get Post by Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        PostDto post = postService.getPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    // update Post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
        PostDto updatePost = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    // Delete post
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
