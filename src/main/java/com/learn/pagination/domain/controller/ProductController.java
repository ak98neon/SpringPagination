package com.learn.pagination.domain.controller;

import com.learn.pagination.domain.entity.Product;
import com.learn.pagination.domain.repository.ProductRepository;
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
@RequestMapping(value = "/product")
public class ProductController {
    private static final String SORT_BY_NAME = "name";
    private static final int PAGE_NUMBER = 0;
    private static final int SIZE_PAGE = 5;
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/")
    public String getAll(@PageableDefault(page = PAGE_NUMBER, size = SIZE_PAGE, sort = SORT_BY_NAME) Pageable pageable,
                         final Model model) {
        Page<Product> productList = productRepository.findAll(pageable);
        model.addAttribute("page", productList);
        return "/productsList";
    }
}
