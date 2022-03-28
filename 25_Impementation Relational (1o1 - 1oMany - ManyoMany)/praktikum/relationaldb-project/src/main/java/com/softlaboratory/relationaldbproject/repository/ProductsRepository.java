package com.softlaboratory.relationaldbproject.repository;

import com.softlaboratory.relationaldbproject.domain.dao.ProductsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsDao, Long> {
}
