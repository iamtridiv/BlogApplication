package com.xofuratech.BlogApplication.services;

import com.xofuratech.BlogApplication.entities.Post;
import com.xofuratech.BlogApplication.payloads.PostDto;
import com.xofuratech.BlogApplication.payloads.PostResponse;

import java.util.List;

public interface PostService {
    // Create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // Update
    PostDto updatePost(PostDto postDto, Integer postId);

    // Delete
    void deletePost(Integer postId);

    // Get Single Post
    PostDto getPostById(Integer postId);

    // Get All Posts
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize);

    // Get all Posts by Category
    List<PostDto> getPostsByCategory(Integer categoryId);

    // Get all Posts by User
    List<PostDto> getPostsByUser(Integer userId);

    // Search Posts
    List<PostDto> searchPosts(String keyword);

}
