package com.learn.pagination.domain.service;

import com.learn.pagination.domain.entity.Category;
import com.learn.pagination.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Artem Kudria
 */
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
