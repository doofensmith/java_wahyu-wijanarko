package com.softlaboratory.springcrudproduct.repository;

import com.softlaboratory.springcrudproduct.domain.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
}
