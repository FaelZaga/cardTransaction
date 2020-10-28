package com.faelzaga.cardTransaction.service;

import com.faelzaga.cardTransaction.entity.Card;
import com.faelzaga.cardTransaction.entity.Payment;
import com.faelzaga.cardTransaction.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Payment createCard(Card card) {
        Payment payment = new Payment(card);
        if (cardRepository.findByNumber(card.getNumber())==null){
            cardRepository.save(card);
        }else{
            payment.addValidation("account-already-initialized");
        }
        return payment;
    }

    public List<Card> getAllCards() {
        return (List<Card>) cardRepository.findAll();
    }
}
