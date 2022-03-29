package com.softlaboratory.relationaldbproject.controller;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.softlaboratory.relationaldbproject.domain.dto.ProductsDto;
import com.softlaboratory.relationaldbproject.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/product")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsController {

    @Autowired
    private ProductsService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable Long productId) {
        return service.getProductById(productId);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveNewProduct(@RequestBody ProductsDto requestBody) {
        return service.saveNewProduct(requestBody);
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long productId, @RequestBody ProductsDto requestBody) {
        return service.updateProduct(productId, requestBody);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long productId) {
        return service.deleteProduct(productId);
    }

    @GetMapping(value = "/query")
    @ResponseBody
    public ResponseEntity<Object> getProductByNameAndCategory(
            @RequestParam(value = "product_name", required = false) String productName,
            @RequestParam(value = "category", required = false) String category) {
        return service.getAllProductByName(productName, category);
    }

    @GetMapping(value = "/sort")
    @ResponseBody
    public ResponseEntity<Object> sortProductByCategory() {
        return service.sortProductByCategory();
    }

    @GetMapping(value = "/page")
    @ResponseBody
    public ResponseEntity<Object> findAllProductPaging(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        return service.findAllProductPaging(page, size);
    }

}
