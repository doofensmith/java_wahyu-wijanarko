package com.softlaboratory.graphqlproject.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.softlaboratory.graphqlproject.domain.dto.AuthorDto;
import com.softlaboratory.graphqlproject.domain.dto.PostDto;
import com.softlaboratory.graphqlproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorResolver implements GraphQLResolver<AuthorDto> {

    @Autowired
    private PostService postService;

    public List<PostDto> getPost(AuthorDto authorDto) {
        return postService.getAllPostByAuthorId(authorDto.getId());
    }

}
