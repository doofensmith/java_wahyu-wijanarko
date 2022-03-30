package com.softlaboratory.nosqlmongodbproject.service;

import com.softlaboratory.nosqlmongodbproject.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction create(Transaction transaction);
    List<Transaction> findAll();
    Transaction findById(String id);
    Transaction update(String id, Transaction transaction);
    void delete(String id);
}
