package com.learn.pagination.domain.service;

import com.learn.pagination.domain.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void save() {
        String name = "save";
        Category category = Category.builder().name(name).products(new ArrayList<>()).build();
        categoryService.save(category);
        assertEquals(name, categoryService.getByName(name).getName());
    }

    @Test
    public void getAll() {
        String name = "getAll";
        Category category = Category.builder().name(name).products(new ArrayList<>()).build();
        categoryService.save(category);
        Page<Category> categoryPage = categoryService.getAll((PageRequest.of(0, 5)));
        assertFalse(categoryPage.getContent().isEmpty());
    }
}
