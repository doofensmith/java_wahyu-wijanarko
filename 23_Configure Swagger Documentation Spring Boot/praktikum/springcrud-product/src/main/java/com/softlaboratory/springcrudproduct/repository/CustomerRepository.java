package com.softlaboratory.springcrudproduct.repository;

import com.softlaboratory.springcrudproduct.domain.dao.CustomerDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDao, Long> {
}
