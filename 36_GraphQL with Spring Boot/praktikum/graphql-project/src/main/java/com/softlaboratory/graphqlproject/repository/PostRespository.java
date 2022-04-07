package com.softlaboratory.graphqlproject.repository;

import com.softlaboratory.graphqlproject.domain.dao.AuthorDao;
import com.softlaboratory.graphqlproject.domain.dao.PostDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRespository extends JpaRepository<PostDao, Long> {

    @Query(value = "select p from PostDao p order by p.createdAt DESC limit :limit offset :offset", nativeQuery = true)
    List<PostDao> getRecentPost(@Param("limit") int limit, @Param("offset") int offset);

    List<PostDao> findAllByAuthor(AuthorDao authorDao);







}
