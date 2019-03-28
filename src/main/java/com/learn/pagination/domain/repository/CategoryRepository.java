package com.learn.pagination.domain.repository;

import com.learn.pagination.domain.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Artem Kudria
 */
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Category findByName(String name);
}
