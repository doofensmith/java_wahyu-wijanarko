package com.softlaboratory.relationaldbproject.repository;

import com.softlaboratory.relationaldbproject.domain.dao.StocksDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stocks extends JpaRepository<StocksDao, Long> {
}
