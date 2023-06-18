package com.cloudProject.service;

import com.cloudProject.domain.post.Post;
import com.cloudProject.domain.post.PostRepository;
import com.cloudProject.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    public final PostRepository postRepository;

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public void delete(Long idx, User user) {
        Post post = postRepository.findByPostIdx(idx).orElseThrow(()-> new IllegalArgumentException("Invalid Post"));
        if(post.getUser()!=user) throw new IllegalArgumentException("Invalid User");
        postRepository.delete(post);
    }
}
