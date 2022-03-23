package com.softlaboratory.springmvc.repository;

import com.softlaboratory.springmvc.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsJpaRepository extends JpaRepository<Posts, Long> {

}
