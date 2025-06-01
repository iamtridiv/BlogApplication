package com.xofuratech.BlogApplication.services;

import com.xofuratech.BlogApplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    // Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // Delete
    void deleteCategory(Integer categoryId);

    // Get All Categories
    List<CategoryDto> getAllCategories();

    // Get Single Category
    CategoryDto getCategoryById(Integer categoryId);


}
