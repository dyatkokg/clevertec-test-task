package me.example.service.impl;

import me.example.entity.Product;
import me.example.exceptions.ProductNotFoundException;
import me.example.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    private Product product;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        product = Product.builder()
                .id(1)
                .name("chicken")
                .onSale(true)
                .price(10)
                .build();
    }

    @Test
    public void whenFindProductById_thenReturnProduct() {
        Product found = productRepository.getById(product.getId()).orElseThrow(() -> new ProductNotFoundException(product.getId()));
        assertEquals(found.getId(), product.getId());
    }
}