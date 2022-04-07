package com.softlaboratory.graphqlproject.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.softlaboratory.graphqlproject.domain.dto.AuthorDto;
import com.softlaboratory.graphqlproject.domain.dto.PostDto;
import com.softlaboratory.graphqlproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostResolver implements GraphQLResolver<PostDto> {

    @Autowired
    private AuthorService authorService;

    public AuthorDto getAuthor(PostDto postDto) {
        return authorService.getAuthorById(postDto.getAuthorId());
    }

}
