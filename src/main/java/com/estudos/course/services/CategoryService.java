package com.estudos.course.services;

import com.estudos.course.models.Category;
import com.estudos.course.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not foung"));
    }
}
