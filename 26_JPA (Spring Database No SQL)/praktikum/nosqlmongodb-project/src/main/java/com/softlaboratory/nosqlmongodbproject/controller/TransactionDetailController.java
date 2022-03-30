package com.softlaboratory.nosqlmongodbproject.controller;

import com.softlaboratory.nosqlmongodbproject.model.TransactionDetail;
import com.softlaboratory.nosqlmongodbproject.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/transaction_detail")
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllTransactionDetail() {
        List<TransactionDetail> transactionDetailList = service.findAll();
        return ResponseEntity.ok(transactionDetailList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTransactionDetailById(@PathVariable String id) {
        TransactionDetail transactionDetail = service.findById(id);
        return ResponseEntity.ok(transactionDetail);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createTransactionDetail(@RequestBody TransactionDetail requestBody) {
        TransactionDetail transactionDetail = service.create(requestBody);
        return ResponseEntity.ok(transactionDetail);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateTransactionDetail(
            @PathVariable String id,
            @RequestBody TransactionDetail requestBody
    ) {
        try {
            TransactionDetail updated = service.update(id, requestBody);
            return ResponseEntity.ok(updated);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteTransactionDetail(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
