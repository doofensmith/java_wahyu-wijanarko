package com.softlaboratory.springactuatorproject.repository;

import com.softlaboratory.springactuatorproject.domain.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
}
