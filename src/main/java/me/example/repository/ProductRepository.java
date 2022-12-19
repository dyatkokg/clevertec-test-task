package me.example.repository;


import me.example.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Optional<Product> getById(Integer k);
}
