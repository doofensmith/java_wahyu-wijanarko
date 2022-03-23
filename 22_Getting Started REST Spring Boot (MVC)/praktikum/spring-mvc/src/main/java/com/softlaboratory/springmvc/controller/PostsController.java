package com.softlaboratory.springmvc.controller;

import com.softlaboratory.springmvc.entity.Posts;
import com.softlaboratory.springmvc.repository.PostsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PostsController {

    @Autowired
    private PostsJpaRepository jpaRepository;

    @GetMapping("/posts")
    public List<Posts> getAllPosts() {
        return jpaRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Optional<Posts> getPost(@PathVariable Long id) {
        return jpaRepository.findById(id);
    }

    @PostMapping("/posts")
    public Posts newPost(@RequestBody Posts posts) {
        return jpaRepository.save(posts);
    }

    @PutMapping("/posts/{id}")
    public Optional<Posts> updatePost(@PathVariable Long id, @RequestBody Posts posts) {
        Optional<Posts> postById = jpaRepository.findById(id);

        if (postById.isPresent()) {
            Posts result = postById.get();
            result.setTitle(posts.getTitle());
            result.setContent(posts.getContent());
            result.setWriter(posts.getWriter());
            jpaRepository.save(result);
        }

        return jpaRepository.findById(id);

    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        Optional<Posts> postById = jpaRepository.findById(id);
        if (postById.isPresent()) {
            jpaRepository.deleteById(id);
        }

    }

}
