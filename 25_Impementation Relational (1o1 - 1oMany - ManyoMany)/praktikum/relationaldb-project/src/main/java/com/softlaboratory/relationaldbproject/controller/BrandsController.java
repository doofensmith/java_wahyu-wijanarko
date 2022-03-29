package com.softlaboratory.relationaldbproject.controller;

import com.softlaboratory.relationaldbproject.domain.dto.BrandsDto;
import com.softlaboratory.relationaldbproject.service.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/brand")
public class BrandsController {

    @Autowired
    private BrandsService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllBrands() {
        return service.getAllBrand();
    }

    @GetMapping(value = "/{brandId}")
    public ResponseEntity<Object> getBrandById(@PathVariable Long brandId) {
        return service.getBrandById(brandId);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveNewBrand(@RequestBody BrandsDto requestBody) {
        return service.saveNewBrand(requestBody);
    }

    @PutMapping(value = "/{brandId}")
    public ResponseEntity<Object> updateBrand(@PathVariable Long brandId, @RequestBody BrandsDto requestBody) {
        return service.updateBrand(brandId, requestBody);
    }

    @DeleteMapping(value = "/{brandId}")
    public ResponseEntity<Object> deleteBrand(@PathVariable Long brandId) {
        return service.deleteBrand(brandId);
    }

}
