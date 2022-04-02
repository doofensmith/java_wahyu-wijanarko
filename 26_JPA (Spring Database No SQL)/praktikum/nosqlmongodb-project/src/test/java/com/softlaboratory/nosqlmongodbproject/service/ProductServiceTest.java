package com.softlaboratory.nosqlmongodbproject.service;

import com.softlaboratory.nosqlmongodbproject.model.Product;
import com.softlaboratory.nosqlmongodbproject.repository.ProductRepository;
import com.softlaboratory.nosqlmongodbproject.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ProductServiceImpl.class)
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private ProductServiceImpl productService;

//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }

//    @Test
//    void findById_ReturnNull() {
//        Product product = easyRandom.nextObject(Product.class);
//        String id = product.getId();
//
//        Mockito.when(productRepository.findById(id)).thenReturn(Optional.empty());
//
//        Product result = productService.findById(id);
//
//        Mockito.verify(productRepository, Mockito.times(1)).findById(id);
//        Assertions.assertEquals(null,result);
//    }
//
//    @Test
//    void findById_ReturnObject() {
//        Product product = easyRandom.nextObject(Product.class);
//        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
//
//        Object result = productService.findById(product.getId());
//
//        Mockito.verify(productRepository, Mockito.times(1)).findById(product.getId());
//        Product output = modelMapper.map(product, Product.class);
//        Assertions.assertEquals(output, result);
//
//    }

    @Test
    void saveProduct_Success() {

        Product product = Product.builder()
                .id("id")
                .name("Test product")
                .price(20000)
                .build();

        Mockito.when(modelMapper.map(Mockito.any(), Mockito.eq(Product.class))).thenReturn(product);
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);

        Product response = productService.create(product);

        Assertions.assertEquals(product, response);
        Mockito.verify(productRepository, Mockito.times(1)).save(product);

    }

    @Test
    void saveProduct_Failed_BadPayload() {

        Product product = null;

        Mockito.when(modelMapper.map(Mockito.any(), Mockito.eq(Product.class))).thenReturn(product);
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);

        Product response = productService.create(product);

        Assertions.assertEquals(null, response);
        Mockito.verify(productRepository, Mockito.times(1)).save(product);

    }

    @Test
    void deleteProduct_Success() {

        Mockito.when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(Product.builder()
                .id("Id")
                .name("Test Product")
                .price(20000)
                .build()));

        Mockito.doNothing().when(productRepository).delete(Mockito.any());

        productService.delete("Id");

        Mockito.verify(productRepository, Mockito.times(1)).delete(Mockito.any());

    }


}