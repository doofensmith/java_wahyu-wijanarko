package com.softlaboratory.customerdataservice.service;

import com.softlaboratory.customerdataservice.dao.CustomerDao;
import com.softlaboratory.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDao save(CustomerDao request) {
        return customerRepository.save(request);
    }

    public CustomerDao getById(Long id) {
        Optional<CustomerDao> productDao = customerRepository.findById(id);

        if (productDao.isEmpty()) {
            return null;
        }else {
            return productDao.get();
        }
    }

}
