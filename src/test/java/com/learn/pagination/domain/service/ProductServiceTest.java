package com.learn.pagination.domain.service;

import com.learn.pagination.domain.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void save() {
        String name = "save";
        Product product = Product.builder().name(name).price(100d).build();
        productService.save(product);
        Product findProduct = productService.getByName(name);
        assertEquals(name, findProduct.getName());
    }

    @Test
    public void getAllByPrice() {
        String name = "getAllByPrice";
        Double price = 100d;
        Product product = Product.builder().name(name).price(price).build();
        productService.save(product);
        List<Product> list = productService.getAllByPrice(price, PageRequest.of(0, 5));
        assertFalse(list.isEmpty());
    }

    @Test
    public void getAll() {
        String name = "getAll";
        Double price = 100d;
        Product product = Product.builder().name(name).price(price).build();
        productService.save(product);
        Page<Product> list = productService.getAll(PageRequest.of(0, 5));
        assertFalse(list.getContent().isEmpty());
    }

    @Test
    public void getByName() {
        String name = "getByName";
        Double price = 100d;
        Product product = Product.builder().name(name).price(price).build();
        productService.save(product);
        Product findProduct = productService.getByName(name);
        assertEquals(name, findProduct.getName());
    }
}
