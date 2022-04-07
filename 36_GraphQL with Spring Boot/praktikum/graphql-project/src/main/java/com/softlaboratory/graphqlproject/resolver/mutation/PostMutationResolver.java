package com.softlaboratory.graphqlproject.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.softlaboratory.graphqlproject.domain.dto.PostDto;
import com.softlaboratory.graphqlproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private PostService postService;

    public PostDto writePost(String title, String text, String category, Long authorId) {
        return postService.writePost(title, text, category, authorId);
    }

}
