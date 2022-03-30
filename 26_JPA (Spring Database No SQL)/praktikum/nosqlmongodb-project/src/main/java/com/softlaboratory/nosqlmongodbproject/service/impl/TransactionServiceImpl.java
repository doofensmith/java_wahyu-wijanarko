package com.softlaboratory.nosqlmongodbproject.service.impl;

import com.softlaboratory.nosqlmongodbproject.model.Transaction;
import com.softlaboratory.nosqlmongodbproject.repository.TransactionRepository;
import com.softlaboratory.nosqlmongodbproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        Transaction payload = Transaction.builder()
                .customerName(transaction.getCustomerName())
                .transactionDetails(transaction.getTransactionDetails())
                .isPaid(transaction.getIsPaid())
                .createdAt(LocalDateTime.now())
                .build();
        return transactionRepository.save(payload);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(String id) {
        Optional<Transaction> transactionById = transactionRepository.findById(id);
        if (transactionById.isPresent()) {
            return transactionById.get();
        }else {
            return null;
        }
    }

    @Override
    public Transaction update(String id, Transaction transaction) {
        Optional<Transaction> transactionById = transactionRepository.findById(id);
        if (transactionById.isPresent()) {
            transactionById.get().setCustomerName(transaction.getCustomerName());
            transactionById.get().setTransactionDetails(transaction.getTransactionDetails());
            transactionById.get().setIsPaid(transaction.getIsPaid());
            return transactionRepository.save(transactionById.get());
        }else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        Optional<Transaction> transactionById = transactionRepository.findById(id);
        if (transactionById.isPresent()) {
            transactionRepository.deleteById(id);
        }
    }
}
