package com.softlaboratory.nosqlmongodbproject.service.impl;

import com.softlaboratory.nosqlmongodbproject.model.Product;
import com.softlaboratory.nosqlmongodbproject.repository.ProductRepository;
import com.softlaboratory.nosqlmongodbproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(()->{
            throw new Error("ID Not Found");
        });
    }

    @Override
    public Product update(String id, Product product) {
        Optional<Product> oldProduct = productRepository.findById(id);
        if (oldProduct.isPresent()) {
            oldProduct.get().setName(product.getName());
            oldProduct.get().setPrice(product.getPrice());
            return productRepository.save(oldProduct.get());
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
    }
}
