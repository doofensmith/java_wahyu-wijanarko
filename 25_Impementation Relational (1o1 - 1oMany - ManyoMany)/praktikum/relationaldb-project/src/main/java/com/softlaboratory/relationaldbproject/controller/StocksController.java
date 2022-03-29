package com.softlaboratory.relationaldbproject.controller;

import com.softlaboratory.relationaldbproject.domain.dto.CategoriesDto;
import com.softlaboratory.relationaldbproject.domain.dto.StocksDto;
import com.softlaboratory.relationaldbproject.service.CategoriesService;
import com.softlaboratory.relationaldbproject.service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/stock")
public class StocksController {

    @Autowired
    private StocksService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllStock() {
        return service.getAllStock();
    }

    @GetMapping(value = "/{stockId}")
    public ResponseEntity<Object> getStockById(@PathVariable Long stockId) {
        return service.getStockById(stockId);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveNewStock(@RequestBody StocksDto requestBody) {
        return service.saveNewStock(requestBody);
    }

    @PutMapping(value = "/{stockId}")
    public ResponseEntity<Object> updateStock(@PathVariable Long stockId, @RequestBody StocksDto requestBody) {
        return service.updateStock(stockId, requestBody);
    }

    @DeleteMapping(value = "/{stockId}")
    public ResponseEntity<Object> deleteStock(@PathVariable Long stockId) {
        return service.deleteStock(stockId);
    }

}
