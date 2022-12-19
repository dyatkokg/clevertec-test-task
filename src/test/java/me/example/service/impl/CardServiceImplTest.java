package me.example.service.impl;

import me.example.entity.Card;
import me.example.exceptions.CardNotFoundException;
import me.example.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CardServiceImplTest {


    private Card card;
    @Autowired
    private CardRepository cardRepository;

    @BeforeEach
    public void setup() {
        card = Card.builder()
                .id(1)
                .discountCount(10)
                .name("silver")
                .build();
    }


    @Test
    public void whenFindCardById_thenReturnCard() {
        Card found = cardRepository.getById(card.getId()).orElseThrow(() -> new CardNotFoundException(card.getId()));
        System.out.println(found);
        assertEquals(found.getId(), card.getId());
    }

}
