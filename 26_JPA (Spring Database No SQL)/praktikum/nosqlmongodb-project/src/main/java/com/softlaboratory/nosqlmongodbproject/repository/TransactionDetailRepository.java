package com.softlaboratory.nosqlmongodbproject.repository;

import com.softlaboratory.nosqlmongodbproject.model.TransactionDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends MongoRepository<TransactionDetail, String> {
}
