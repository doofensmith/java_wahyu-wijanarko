package com.softlaboratory.graphqlproject.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.softlaboratory.graphqlproject.domain.dto.AuthorDto;
import com.softlaboratory.graphqlproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private AuthorService authorService;

    public List<AuthorDto> getAllAuthor() {
        return authorService.getAllAuthor();
    }

}
