package com.faelzaga.cardTransaction.repository;

import com.faelzaga.cardTransaction.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card,Integer> {
    Card findByNumber(String number);
}
