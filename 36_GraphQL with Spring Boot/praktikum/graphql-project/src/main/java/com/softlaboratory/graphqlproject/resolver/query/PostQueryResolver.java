package com.softlaboratory.graphqlproject.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.softlaboratory.graphqlproject.domain.dto.PostDto;
import com.softlaboratory.graphqlproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PostService postService;

    public List<PostDto> getAllPost() {
        return postService.getAllPost();
    }

    public List<PostDto> recentPost(int limit, int offset) {
        return postService.getRecentPost(limit, offset);
    }

}
