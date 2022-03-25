package com.softlaboratory.springcrudproduct.controller;

import com.softlaboratory.springcrudproduct.domain.dto.CustomerDto;
import com.softlaboratory.springcrudproduct.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(value = "/customer")
    public ResponseEntity<Object> getAllCustomer() {
        return service.getAllCustomer();
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<Object> saveNewCustomer(@RequestBody CustomerDto reqBody) {
        return service.saveNewCustomer(reqBody);
    }

    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto reqBody) {
        return service.updateCustomer(id, reqBody);
    }

    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
        return service.deleteCustomer(id);
    }

}
