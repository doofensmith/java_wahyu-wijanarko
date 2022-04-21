package com.softlaboratory.transactionservice.service;

import com.softlaboratory.transactionservice.domain.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${customer-data-service.url}")
    private String customerServiceUrl;

    public CustomerDto getCustomerById(Long id) {
        try {
            CustomerDto customerDto = restTemplate.getForObject(String.format("%s/customer/%s",customerServiceUrl,id), CustomerDto.class);
            return customerDto;
        }catch (Exception e) {
            throw e;
        }
    }

}
