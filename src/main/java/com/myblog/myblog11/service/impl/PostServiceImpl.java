package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       Post post = new Post();
       post.setTittle(postDto.getTittle());
       post.setDescription(postDto.getDescription());
       post.setContent(postDto.getContent());
        Post savePost = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setTittle(savePost.getTittle());
        dto.setDescription(savePost.getDescription());
        dto.setContent(savePost.getContent());
        return dto;
    }
}
