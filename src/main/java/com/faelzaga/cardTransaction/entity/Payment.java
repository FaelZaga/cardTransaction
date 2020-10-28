package com.faelzaga.cardTransaction.entity;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private Card card;
    private List<String> validations = new ArrayList<>();

    public Payment(Card card) {
        this.card = card;
    }

    public void getPaid(double amount) {
        card.setAvailableLimit(card.getAvailableLimit() - amount);
    }

    public void addValidation(String validation) {
        validations.add(validation);
    }

    public Card getCard() {
        return card;
    }

    public List<String> getValidations() {
        return validations;
    }
}
