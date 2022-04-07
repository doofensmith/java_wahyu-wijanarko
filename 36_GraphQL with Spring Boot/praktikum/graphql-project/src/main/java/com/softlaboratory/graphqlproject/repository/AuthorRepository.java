package com.softlaboratory.graphqlproject.repository;

import com.softlaboratory.graphqlproject.domain.dao.AuthorDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDao, Long> {
}
