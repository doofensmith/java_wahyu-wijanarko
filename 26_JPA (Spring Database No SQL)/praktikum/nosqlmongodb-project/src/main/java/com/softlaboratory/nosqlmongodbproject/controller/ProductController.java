package com.softlaboratory.nosqlmongodbproject.controller;

import com.softlaboratory.nosqlmongodbproject.model.Product;
import com.softlaboratory.nosqlmongodbproject.service.ProductService;
import com.softlaboratory.nosqlmongodbproject.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllProduct() {
        List<Product> productList = service.findAll();
        return ResponseEntity.ok(productList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable String id) {
        Product product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createProduct(@RequestBody Product requestBody) {
        Product product = service.create(requestBody);
        return ResponseEntity.ok(product);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateProduct(
            @PathVariable String id,
            @RequestBody Product requestBody
    ) {
        try {
            Product updated = service.update(id, requestBody);
            return ResponseEntity.ok(updated);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
