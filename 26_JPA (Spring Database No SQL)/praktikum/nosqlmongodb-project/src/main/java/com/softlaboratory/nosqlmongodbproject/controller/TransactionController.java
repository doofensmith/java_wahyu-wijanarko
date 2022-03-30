package com.softlaboratory.nosqlmongodbproject.controller;

import com.softlaboratory.nosqlmongodbproject.model.Transaction;
import com.softlaboratory.nosqlmongodbproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllTransaction() {
        List<Transaction> transactionList = service.findAll();
        return ResponseEntity.ok(transactionList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTransactionById(@PathVariable String id) {
        Transaction transaction = service.findById(id);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createTransaction(@RequestBody Transaction requestBody) {
        Transaction transaction = service.create(requestBody);
        return ResponseEntity.ok(transaction);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateTransaction(
            @PathVariable String id,
            @RequestBody Transaction requestBody
    ) {
        try {
            Transaction updated = service.update(id, requestBody);
            return ResponseEntity.ok(updated);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteTransaction(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
