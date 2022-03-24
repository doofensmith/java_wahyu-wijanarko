package com.softlaboratory.springcrudproduct.controller;

import com.softlaboratory.springcrudproduct.domain.dto.ProductDto;
import com.softlaboratory.springcrudproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class ProductController {

    @Autowired
    ProductService service;

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

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return service.updateProduct(id, productDto);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        return service.deleteProduct(id);
    }

}
