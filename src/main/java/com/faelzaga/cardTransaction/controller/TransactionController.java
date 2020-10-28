package com.faelzaga.cardTransaction.controller;

import com.faelzaga.cardTransaction.entity.Payment;
import com.faelzaga.cardTransaction.entity.Transaction;
import com.faelzaga.cardTransaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/{number}")
    public ResponseEntity<Payment> transaction(@PathVariable String number, @RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.transaction(number,transaction));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
}
