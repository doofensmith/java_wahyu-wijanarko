package com.softlaboratory.transactionservice.service;

import com.softlaboratory.transactionservice.domain.dto.CustomerDto;
import com.softlaboratory.transactionservice.domain.dto.ProductDto;
import com.softlaboratory.transactionservice.domain.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    public TransactionDto saveTransaction(TransactionDto request) {
        CustomerDto customerDto = customerService.getCustomerById(request.getCustomer().getId());
        ProductDto productDto = productService.getProductById(request.getProduct().getId());

        Integer totalPrice = productDto.getPrice() * request.getQty();

        return TransactionDto.builder()
                .customer(customerDto)
                .product(productDto)
                .totalPrice(totalPrice)
                .qty(request.getQty())
                .build();
    }

}
