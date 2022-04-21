package com.softlaboratory.customerdataservice.controller;

import com.softlaboratory.customerdataservice.dao.CustomerDao;
import com.softlaboratory.customerdataservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "")
    public CustomerDao save(@RequestBody CustomerDao request) {
        return customerService.save(request);
    }

    @GetMapping(value = "/{id}")
    public CustomerDao getById(@PathVariable(value = "id") Long id) {
        return customerService.getById(id);
    }

}
