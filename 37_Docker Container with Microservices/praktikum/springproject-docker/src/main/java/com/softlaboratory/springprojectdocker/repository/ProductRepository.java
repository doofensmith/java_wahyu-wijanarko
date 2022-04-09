package com.softlaboratory.springprojectdocker.repository;

import com.softlaboratory.springprojectdocker.domain.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
}
