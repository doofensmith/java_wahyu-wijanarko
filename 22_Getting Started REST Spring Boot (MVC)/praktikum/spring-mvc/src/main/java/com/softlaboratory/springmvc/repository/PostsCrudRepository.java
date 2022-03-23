package com.softlaboratory.springmvc.repository;

import com.softlaboratory.springmvc.entity.Posts;
import org.springframework.data.repository.CrudRepository;

public interface PostsCrudRepository extends CrudRepository<Posts, Long> {
}
