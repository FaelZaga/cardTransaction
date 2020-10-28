package com.faelzaga.cardTransaction.repository;

import com.faelzaga.cardTransaction.entity.Card;
import com.faelzaga.cardTransaction.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
    List<Transaction> findAllByCard(Card card);
}
