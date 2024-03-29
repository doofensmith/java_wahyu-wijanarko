package com.softlaboratory.relationaldbproject.repository;

import com.softlaboratory.relationaldbproject.domain.dao.CategoriesDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesDao, Long> {
}
