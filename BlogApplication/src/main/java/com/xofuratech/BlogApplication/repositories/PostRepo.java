package com.xofuratech.BlogApplication.repositories;

import com.xofuratech.BlogApplication.entities.Category;
import com.xofuratech.BlogApplication.entities.Post;
import com.xofuratech.BlogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    // Custom query methods can be defined here if needed
    // For example, to find posts by title or author, etc.
    public List<Post> findByUser(User user);
    public List<Post> findByCategory(Category category);
    public List<Post> findByTitleContaining(String title);
}
