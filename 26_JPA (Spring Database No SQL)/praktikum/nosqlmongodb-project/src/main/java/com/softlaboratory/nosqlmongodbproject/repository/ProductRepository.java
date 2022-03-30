package com.softlaboratory.nosqlmongodbproject.repository;

import com.softlaboratory.nosqlmongodbproject.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
