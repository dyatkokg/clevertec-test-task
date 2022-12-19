package me.example.repository;


import me.example.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card,Integer> {

    Optional<Card> getById(Integer k);
}
