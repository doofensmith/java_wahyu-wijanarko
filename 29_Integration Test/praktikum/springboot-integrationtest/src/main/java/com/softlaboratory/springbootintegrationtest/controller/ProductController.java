package com.softlaboratory.springbootintegrationtest.controller;

import com.softlaboratory.springbootintegrationtest.domain.dto.ProductDto;
import com.softlaboratory.springbootintegrationtest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/product")
    public ResponseEntity<Object> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Object> saveNewProduct(@RequestBody ProductDto productDto) {
        return service.saveNewProduct(productDto);
    }

    @PatchMapping(value = "/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return service.updateProduct(id, productDto);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        return service.deleteProduct(id);
    }

}
