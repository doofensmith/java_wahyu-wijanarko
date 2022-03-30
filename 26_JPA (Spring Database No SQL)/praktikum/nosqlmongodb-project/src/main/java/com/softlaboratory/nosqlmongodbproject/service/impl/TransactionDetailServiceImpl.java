package com.softlaboratory.nosqlmongodbproject.service.impl;

import com.softlaboratory.nosqlmongodbproject.model.TransactionDetail;
import com.softlaboratory.nosqlmongodbproject.repository.TransactionDetailRepository;
import com.softlaboratory.nosqlmongodbproject.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Override
    public TransactionDetail create(TransactionDetail transactionDetail) {
        return transactionDetailRepository.save(transactionDetail);
    }

    @Override
    public List<TransactionDetail> findAll() {
        return transactionDetailRepository.findAll();
    }

    @Override
    public TransactionDetail findById(String id) {
        Optional<TransactionDetail> transactionDetailById = transactionDetailRepository.findById(id);
        if (transactionDetailById.isPresent()) {
            return transactionDetailById.get();
        }else {
            return null;
        }
    }

    @Override
    public TransactionDetail update(String id, TransactionDetail transactionDetail) {
        Optional<TransactionDetail> transactionDetailById = transactionDetailRepository.findById(id);
        if (transactionDetailById.isPresent()) {
            transactionDetailById.get().setQuantity(transactionDetail.getQuantity());
            return transactionDetailRepository.save(transactionDetailById.get());
        }else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        Optional<TransactionDetail> transactionDetailById = transactionDetailRepository.findById(id);
        if (transactionDetailById.isPresent()) {
            transactionDetailRepository.deleteById(id);
        }
    }
}
