package com.softlaboratory.springcrudproduct.service;

import com.softlaboratory.springcrudproduct.constant.AppConstant;
import com.softlaboratory.springcrudproduct.domain.dao.CustomerDao;
import com.softlaboratory.springcrudproduct.domain.dto.CustomerDto;
import com.softlaboratory.springcrudproduct.repository.CustomerRepository;
import com.softlaboratory.springcrudproduct.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Object> getAllCustomer() {
        List<CustomerDao> customerDaoList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (CustomerDao customerDao : customerDaoList) {
            customerDtoList.add(CustomerDto.builder()
                    .id(customerDao.getId())
                    .name(customerDao.getName())
                    .gender(customerDao.getGender())
                    .build()
            );
        }

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, customerDtoList);
    }

    public ResponseEntity<Object> getCustomerById(Long id) {
        Optional<CustomerDao> customerDao = customerRepository.findById(id);

        if (customerDao.isPresent()) {
            CustomerDto customerDto = CustomerDto.builder()
                    .id(customerDao.get().getId())
                    .name(customerDao.get().getName())
                    .gender(customerDao.get().getGender())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, customerDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> saveNewCustomer(CustomerDto reqBody) {
        CustomerDao customerDao = CustomerDao.builder()
                .name(reqBody.getName())
                .gender(reqBody.getGender())
                .build();
        customerRepository.save(customerDao);

        CustomerDto customerDto = CustomerDto.builder()
                .id(customerDao.getId())
                .name(customerDao.getName())
                .gender(customerDao.getGender())
                .build();

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, customerDto);
    }

    public ResponseEntity<Object> updateCustomer(Long id, CustomerDto reqBody) {
        Optional<CustomerDao> customerDaoOld = customerRepository.findById(id);

        if (customerDaoOld.isPresent()) {
            CustomerDao customerDaoNew = customerDaoOld.get();
            customerDaoNew.setName(reqBody.getName());
            customerDaoNew.setGender(reqBody.getGender());
            customerRepository.save(customerDaoNew);

            CustomerDto customerDto = CustomerDto.builder()
                    .id(customerDaoNew.getId())
                    .name(customerDaoNew.getName())
                    .gender(customerDaoNew.getGender())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, customerDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> deleteCustomer(Long id) {
        Optional<CustomerDao> customerDao = customerRepository.findById(id);

        if (customerDao.isPresent()) {
            customerRepository.deleteById(id);
            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, null);
        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

}
