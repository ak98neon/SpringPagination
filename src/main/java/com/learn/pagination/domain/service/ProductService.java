package com.learn.pagination.domain.service;

import com.learn.pagination.domain.entity.Product;
import com.learn.pagination.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /**
     * @see ProductRepository#save(Object)
     */
    public void save(Product product) {
        productRepository.save(product);
    }

    /**
     * @see ProductRepository#findAllByPrice(Double, Pageable)
     */
    public List<Product> getAllByPrice(Double price, PageRequest pageRequest) {
        return productRepository.findAllByPrice(price, pageRequest);
    }

    /**
     * @see ProductRepository#findAll(Sort)
     */
    public Page<Product> getAll(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    /**
     * @see ProductRepository#findByName(String)
     */
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }
}
