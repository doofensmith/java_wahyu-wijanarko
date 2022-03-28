package com.softlaboratory.relationaldbproject.controller;

import com.softlaboratory.relationaldbproject.domain.dto.ProductsDto;
import com.softlaboratory.relationaldbproject.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/product")
public class ProductsController {

    @Autowired
    private ProductsService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long productId) {
        return service.getProductById(productId);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveNewProduct(@RequestBody ProductsDto requestBody) {
        return service.saveNewProduct(requestBody);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long productId, @RequestBody ProductsDto requestBody) {
        return service.updateProduct(productId, requestBody);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long productId) {
        return service.deleteProduct(productId);
    }

}
