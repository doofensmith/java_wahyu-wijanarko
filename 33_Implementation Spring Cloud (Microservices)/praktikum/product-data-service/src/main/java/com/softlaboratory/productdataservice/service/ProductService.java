package com.softlaboratory.productdataservice.service;

import com.softlaboratory.productdataservice.domain.dao.ProductDao;
import com.softlaboratory.productdataservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDao save(ProductDao request) {
        return productRepository.save(request);
    }

    public ProductDao getById(Long id) {
        Optional<ProductDao> productDao = productRepository.findById(id);

        if (productDao.isEmpty()) {
            return null;
        }else {
            return productDao.get();
        }
    }

}
