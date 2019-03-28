package com.learn.pagination.domain.repository;

import com.learn.pagination.domain.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Artem Kudria
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    /**
     * Find all product by price
     * @param price Double
     * @param pageable Pageable for request all product
     * @return List products
     */
    List<Product> findAllByPrice(Double price, Pageable pageable);

    /**
     * Find product by name
     * @param name String name product
     * @return Product entity
     */
    Product findByName(String name);
}
