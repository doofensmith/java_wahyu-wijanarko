package com.softlaboratory.transactionservice.controller;

import com.softlaboratory.transactionservice.domain.dto.TransactionDto;
import com.softlaboratory.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "")
    public TransactionDto saveTransaction(@RequestBody TransactionDto request) {
        return transactionService.saveTransaction(request);
    }

}
