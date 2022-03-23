package com.softlaboratory.springmvc.controller;

import com.softlaboratory.springmvc.entity.Posts;
import com.softlaboratory.springmvc.repository.PostsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class PostControllerV2 {

    @Autowired
    PostsCrudRepository crudRepository;

    @GetMapping("/posts")
    public List<Posts> getAllPosts() {
        return (List<Posts>) crudRepository.findAll();
    }

}
