package com.faelzaga.cardTransaction.service;

import com.faelzaga.cardTransaction.entity.Payment;
import com.faelzaga.cardTransaction.entity.Transaction;
import com.faelzaga.cardTransaction.repository.CardRepository;
import com.faelzaga.cardTransaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Component
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public Payment transaction(String number, Transaction transaction) {
        Payment payment;

        if (cardRepository.findByNumber(number)==null) {
            payment = new Payment(null);
            payment.addValidation("account-not-initialized");
            return payment;
        }else {
            payment = new Payment(cardRepository.findByNumber(number));
        }

        if (!payment.getCard().getActiveCard()) {
            payment.addValidation("card-not-active");
            return payment;
        }

        if (payment.getCard().getAvailableLimit()<transaction.getAmount()) {
            payment.addValidation("insufficient-limit");
            return payment;
        }

        List<Transaction> historic = transactionRepository.findAllByCard(payment.getCard());
        Collections.sort(historic);

        Calendar cal = Calendar.getInstance();

        if (historic.contains(transaction)) {
            for (int i = historic.size() - 1; i >= 0; i--) {
                if (historic.get(i).equals(transaction)) {

                    cal.setTime(historic.get(i).getDate());
                    cal.add(Calendar.MINUTE, 2);

                    if (transaction.getDate().before(cal.getTime())) {
                        payment.addValidation("doubled-transaction");
                        return payment;
                    }
                }
            }
        }

        if (historic.size() >= 3) {

            cal.setTime(historic.get(historic.size() - 2).getDate());
            cal.add(Calendar.MINUTE, 3);

            if (transaction.getDate().before(cal.getTime())) {
                payment.addValidation("high-frequency-small-interval");
                return payment;
            }
        }

        transaction.setCard(payment.getCard());

        payment.getPaid(transaction.getAmount());

        payment.getCard().addTransaction(transactionRepository.save(transaction));

        return payment;
    }
}
