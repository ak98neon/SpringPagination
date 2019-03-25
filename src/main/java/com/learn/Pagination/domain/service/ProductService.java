package com.learn.Pagination.domain.service;

import com.learn.Pagination.domain.entity.Product;
import com.learn.Pagination.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Artem Kudria
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllByPrice(Double price, PageRequest pageRequest) {
        return productRepository.findAllByPrice(price, pageRequest);
    }

    public Page<Product> getAll(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }
}
