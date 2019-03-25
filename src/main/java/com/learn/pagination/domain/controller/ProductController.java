package com.learn.pagination.domain.controller;

import com.learn.pagination.domain.entity.Product;
import com.learn.pagination.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private static final int PAGE_NUMBER = 0;
    private static final int SIZE_PAGE = 5;
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/")
    public String getAll(final Model model) {
        PageRequest pageRequest = PageRequest.of(PAGE_NUMBER, SIZE_PAGE);
        Page<Product> productList = productRepository.findAll(pageRequest);
        model.addAttribute("products", productList.getContent());
        return "productsList";
    }
}
