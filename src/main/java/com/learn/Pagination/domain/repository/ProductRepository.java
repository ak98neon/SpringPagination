package com.learn.Pagination.domain.repository;

import com.learn.Pagination.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Artem Kudria
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByPrice(Double price, Pageable pageable);
}
