package com.xofuratech.BlogApplication.services.impl;

import com.xofuratech.BlogApplication.entities.Category;
import com.xofuratech.BlogApplication.entities.Post;
import com.xofuratech.BlogApplication.entities.User;
import com.xofuratech.BlogApplication.exceptions.ResourceNotFoundException;
import com.xofuratech.BlogApplication.payloads.PostDto;
import com.xofuratech.BlogApplication.repositories.CategoryRepo;
import com.xofuratech.BlogApplication.repositories.PostRepo;
import com.xofuratech.BlogApplication.repositories.UserRepo;
import com.xofuratech.BlogApplication.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post savedPost = postRepo.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return List.of();
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }
}
