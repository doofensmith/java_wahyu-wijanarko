package com.softlaboratory.relationaldbproject.repository;

import com.softlaboratory.relationaldbproject.domain.dao.BrandsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepository extends JpaRepository<BrandsDao, Long> {
}
