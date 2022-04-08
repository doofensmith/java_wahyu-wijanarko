package com.softlaboratory.graphqlproject.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.softlaboratory.graphqlproject.domain.dto.AuthorDto;
import com.softlaboratory.graphqlproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private AuthorService authorService;

    public AuthorDto addAuthor(String name, String thumbnail) {
        return authorService.addAuthor(name, thumbnail);
    }

}
