package com.softlaboratory.springbootintegrationtest.repository;

import com.softlaboratory.springbootintegrationtest.domain.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
}
