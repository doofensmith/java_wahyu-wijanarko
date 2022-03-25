package com.softlaboratory.springcrudproduct.controller;

import com.softlaboratory.springcrudproduct.domain.dto.ProductDto;
import com.softlaboratory.springcrudproduct.service.ProductService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/product")
    @ApiOperation(value = "Get All Product", notes = "Method ini menampilkan semua data Product.")
    public ResponseEntity<Object> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping(value = "/product/{id}")
    @ApiOperation(value = "Get Product By Id", notes = "Method ini menampilkan data Product berdasarkan Id.")
    public ResponseEntity<Object> getProductById(@ApiParam(
            name = "id",
            value = "Id dari sebuah Product.",
            required = true
    ) @PathVariable Long id) {
        return service.getProductById(id);
    }

    @PostMapping(value = "/product")
    @ApiOperation(value = "Save New Product", notes = "Method ini digunakan untuk membuat data Product baru.")
    public ResponseEntity<Object> saveNewProduct(@RequestBody ProductDto productDto) {
        return service.saveNewProduct(productDto);
    }

    @PutMapping(value = "/product/{id}")
    @ApiOperation(value = "Update Product", notes = "Method ini digunakan untuk mengubah data Product.")
    public ResponseEntity<Object> updateProduct(@ApiParam(
            name = "id",
            value = "Id dari sebuah Product.",
            required = true
    ) @PathVariable Long id, @RequestBody ProductDto productDto) {
        return service.updateProduct(id, productDto);
    }

    @DeleteMapping(value = "/product/{id}")
    @ApiOperation(value = "Delete By Id", notes = "Method ini digunakan untuk menghapus data Product berdasarkan Id.")
    public ResponseEntity<Object> deleteProduct(@ApiParam(
            name = "id",
            value = "Id dari sebuah Product.",
            required = true
    ) @PathVariable Long id) {
        return service.deleteProduct(id);
    }

}
