package com.softlaboratory.nosqlmongodbproject.service;

import com.softlaboratory.nosqlmongodbproject.model.Product;
import com.softlaboratory.nosqlmongodbproject.repository.ProductRepository;
import com.softlaboratory.nosqlmongodbproject.service.impl.ProductServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;


class ProductServiceTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private final ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_ReturnNull() {
        Product product = easyRandom.nextObject(Product.class);
        String id = product.getId();

        Mockito.when(productRepository.findById(id)).thenReturn(Optional.empty());

        Product result = productService.findById(id);

        Mockito.verify(productRepository, Mockito.times(1)).findById(id);
        Assertions.assertEquals(null,result);
    }

    @Test
    void findById_ReturnObject() {
        Product product = easyRandom.nextObject(Product.class);
        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        Object result = productService.findById(product.getId());

        Mockito.verify(productRepository, Mockito.times(1)).findById(product.getId());
        Product output = modelMapper.map(product, Product.class);
        Assertions.assertEquals(output, result);

    }

    @Test
    void saveProduct() {

        Product product = easyRandom.nextObject(Product.class);
        Mockito.when(productRepository.save(product)).thenReturn(product);

        productRepository.save(product);

        Mockito.verify(productRepository,Mockito.times(1)).save(product);

    }

    @Test
    void deleteOne_DoNothing() {

        Mockito.doNothing().when(productRepository).deleteById("asd");

        productService.delete("asd");

        Mockito.verify(productRepository, Mockito.times(1)).deleteById("asd");


    }



}