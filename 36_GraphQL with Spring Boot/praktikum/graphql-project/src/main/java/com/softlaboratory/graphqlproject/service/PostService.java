package com.softlaboratory.graphqlproject.service;

import com.softlaboratory.graphqlproject.domain.dao.AuthorDao;
import com.softlaboratory.graphqlproject.domain.dao.PostDao;
import com.softlaboratory.graphqlproject.domain.dto.PostDto;
import com.softlaboratory.graphqlproject.repository.AuthorRepository;
import com.softlaboratory.graphqlproject.repository.PostRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PostRespository postRespository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<PostDto> getRecentPost(int limit, int offset) {
        try {
            List<PostDao> postDaoList = postRespository.getRecentPost(limit, offset);
            List<PostDto> postDtoList = new ArrayList<>();
            for (PostDao postDao : postDaoList) {
                postDtoList.add(modelMapper.map(postDao, PostDto.class));
            }

            return postDtoList;

        }catch (Exception e) {
            throw e;
        }
    }

    public List<PostDto> getAllPost() {
        try {
            List<PostDao> postDaoList = postRespository.findAll();
            List<PostDto> postDtoList = new ArrayList<>();
            for (PostDao postDao : postDaoList) {
                postDtoList.add(modelMapper.map(postDao, PostDto.class));
            }

            return postDtoList;

        }catch (Exception e) {
            throw e;
        }
    }

    public List<PostDto> getAllPostByAuthorId(Long authorId) {
        try {
            Optional<AuthorDao> authorDao = authorRepository.findById(authorId);
            if (authorDao.isPresent()) {
                List<PostDao> postDaoList = postRespository.findAllByAuthor(authorDao.get());
                List<PostDto> postDtoList = new ArrayList<>();
                for (PostDao postDao : postDaoList) {
                    postDtoList.add(modelMapper.map(postDao, PostDto.class));
                }
                return postDtoList;
            }else {
                throw new IllegalArgumentException("author not found.");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public PostDto writePost(String title, String text, String category, Long authorId) {
        try {
            Optional<AuthorDao> authorDao = authorRepository.findById(authorId);
            if (authorDao.isPresent()) {
                PostDto postDto = PostDto.builder()
                        .title(title)
                        .text(text)
                        .category(category)
                        .authorId(authorId)
                        .build();
                PostDao postDao = modelMapper.map(postDto, PostDao.class);
                postDao.setAuthor(authorDao.get());
                postDao = postRespository.save(postDao);
                return modelMapper.map(postDao, PostDto.class);
            }else {
                throw new IllegalArgumentException("author not found.");
            }
        }catch (Exception e) {
            throw e;
        }
    }

}
