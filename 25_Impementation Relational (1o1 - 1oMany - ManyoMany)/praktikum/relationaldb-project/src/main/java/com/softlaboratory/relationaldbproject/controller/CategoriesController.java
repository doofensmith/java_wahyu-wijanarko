package com.softlaboratory.relationaldbproject.controller;

import com.softlaboratory.relationaldbproject.domain.dto.CategoriesDto;
import com.softlaboratory.relationaldbproject.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/category")
public class CategoriesController {

    @Autowired
    private CategoriesService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllCategory() {
        return service.getAllCategory();
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long categoryId) {
        return service.getCategoryById(categoryId);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveNewCategory(@RequestBody CategoriesDto requestBody) {
        return service.saveNewCategory(requestBody);
    }

    @PutMapping(value = "/{categoryId}")
    public ResponseEntity<Object> updateCategory(@PathVariable Long categoryId, @RequestBody CategoriesDto requestBody) {
        return service.updateCategory(categoryId, requestBody);
    }

    @DeleteMapping(value = "/{categoryId}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long categoryId) {
        return service.deleteCategory(categoryId);
    }

}
