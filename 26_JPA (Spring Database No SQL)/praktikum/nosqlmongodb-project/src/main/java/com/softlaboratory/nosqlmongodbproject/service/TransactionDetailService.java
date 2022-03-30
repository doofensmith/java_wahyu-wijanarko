package com.softlaboratory.nosqlmongodbproject.service;

import com.softlaboratory.nosqlmongodbproject.model.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    TransactionDetail create(TransactionDetail transactionDetail);
    List<TransactionDetail> findAll();
    TransactionDetail findById(String id);
    TransactionDetail update(String id, TransactionDetail transactionDetail);
    void delete(String id);
}
