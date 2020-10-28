package com.faelzaga.cardTransaction.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Transaction implements Comparable<Transaction>{

    @Id
    @GeneratedValue
    @Column(name="transaction_id")
    private int id;

    @Column(name="merchant")
    private String merchant;

    @Column(name="amount")
    private double amount;

    @Column(name="date")
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name="card_id")
    private Card card;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public int compareTo(Transaction other) {
        return this.date.compareTo(other.getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                merchant.equals(that.merchant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchant, amount);
    }
}
