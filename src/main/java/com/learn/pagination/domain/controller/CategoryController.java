package com.learn.pagination.domain.controller;

import com.learn.pagination.domain.entity.Category;
import com.learn.pagination.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Artem Kudria
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/")
    public String getAllCategory(@PageableDefault(sort = "name") Pageable pageable,
                                 Model model) {
        Page<Category> categoryPage = categoryService.getAll(pageable);
        model.addAttribute("categories", categoryPage);
        return "/categoryList";
    }
}
