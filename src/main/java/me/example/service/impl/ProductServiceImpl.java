package me.example.service.impl;

import lombok.RequiredArgsConstructor;
import me.example.entity.Product;
import me.example.exceptions.ProductNotFoundException;
import me.example.repository.ProductRepository;
import me.example.service.ProductService;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;


    @Override
    public Product getProduct(Integer id) {
        return productRepository.getById(id).orElseThrow(()->new ProductNotFoundException(id));
    }

}
