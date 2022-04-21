package com.softlaboratory.productdataservice.controller;

import com.softlaboratory.productdataservice.domain.dao.ProductDao;
import com.softlaboratory.productdataservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "")
    public ProductDao save(@RequestBody ProductDao request) {
        return productService.save(request);
    }

    @GetMapping(value = "/{id}")
    public ProductDao getById(@PathVariable(value = "id") Long id) {
        return productService.getById(id);
    }

}
