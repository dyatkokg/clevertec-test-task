//package me.example.service.impl;
//
//import me.example.entity.Card;
//import me.example.repository.CardRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
//class CardServiceImplTest {
//
//    @Mock
//    private CardRepository cardRepository;
//
//    @InjectMocks
//    private CardServiceImpl cardService;
//
//    private Card card;
//
//
//    @BeforeEach
//    public void setup(){
//        card = Card.builder()
//                .id(1)
//                .discountCount(10)
//                .name("gold")
//                .build();
//    }
//    @DisplayName("JUnit test for getCardById method")
//    @Test
//    public void givenCardId_whenGetCardById_thenReturnCardObject(){
//        System.out.println(card.getId());
//        System.out.println(cardService.getCard(card.getId()));
//        Card savedCard = cardService.getCard(card.getId());
//        assertThat(savedCard).isNotNull();
//
//    }
//}