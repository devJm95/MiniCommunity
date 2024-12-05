package com.MiniCommunity.domain.post.entity;

import com.MiniCommunity.domain.user.entity.User;
import com.MiniCommunity.domain.post.dro.PostDTO;
import com.MiniCommunity.domain.like.entity.Likes;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private  String title;
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Likes> likes = new HashSet<>();

    public static Post toEntity(PostDTO postDTO, User user) {
        return Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .build();
    }
}
