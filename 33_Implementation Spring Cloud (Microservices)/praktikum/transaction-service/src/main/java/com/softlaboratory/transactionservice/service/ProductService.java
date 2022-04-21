package com.softlaboratory.transactionservice.service;

import com.softlaboratory.transactionservice.domain.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product-data-service.url}")
    private String productServiceUrl;

    public ProductDto getProductById(Long id) {
        try {
            ProductDto productDto = restTemplate.getForObject(String.format("%s/product/%s",productServiceUrl,id), ProductDto.class);
            return productDto;
        }catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<ProductDto> getProductById2(Long id) {
        try {

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<ProductDto> httpEntity = new HttpEntity<>(httpHeaders);
            ProductDto productDto = restTemplate.exchange(String.format("%s/product/%s",productServiceUrl,id), HttpMethod.GET, httpEntity, ProductDto.class).getBody();
            return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
        }catch (Exception e) {
            throw e;
        }
    }

}
