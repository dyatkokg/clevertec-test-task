package me.example.service.impl;

import lombok.RequiredArgsConstructor;
import me.example.entity.Card;
import me.example.exceptions.CardNotFoundException;
import me.example.repository.CardRepository;
import me.example.service.CardService;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {


    private final CardRepository cardRepository;


    @Override
    public Card getCard(Integer id) {
        return cardRepository.getById(id).orElseThrow(()->new CardNotFoundException(id));
    }

}