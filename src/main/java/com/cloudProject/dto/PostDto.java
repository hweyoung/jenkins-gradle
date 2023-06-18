package com.cloudProject.dto;

import com.cloudProject.domain.post.Post;
import lombok.Data;

@Data
public class PostDto {
    private String title;
    private String content;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
