package com.example.skillbridge.mapper;

import com.example.skillbridge.dto.request.CategoryRequest;
import com.example.skillbridge.dto.response.CategoryResponse;
import com.example.skillbridge.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
