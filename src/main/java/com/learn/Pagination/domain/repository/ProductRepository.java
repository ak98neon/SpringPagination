package com.learn.Pagination.domain.repository;

import com.learn.Pagination.domain.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author Artem Kudria
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findAllByPrice(Double price, Pageable pageable);
}
