package com.learn.Pagination.domain.repository;

import com.learn.Pagination.domain.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Artem Kudria
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findAllByPrice(Double price, Pageable pageable);
}
