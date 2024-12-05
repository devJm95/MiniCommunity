package com.MiniCommunity.domain.post.service;


import com.MiniCommunity.common.component.FinderId;
import com.MiniCommunity.domain.post.dro.PostDTO;
import com.MiniCommunity.domain.post.entity.Post;
import com.MiniCommunity.domain.user.entity.User;
import com.MiniCommunity.domain.post.repository.PostRepository;
import com.MiniCommunity.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FinderId finderId;

    @Transactional
    public Post saveOrUpdatePost(PostDTO postDTO, Long userId) {
        User user = finderId.findById(userRepository, userId, "User");

        Post post;

        if(postDTO.getId() == null){
            post = Post.toEntity(postDTO, user);
        } else {
            post = finderId.findById(postRepository, postDTO.getId(), "Post");
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
        }

        return postRepository.save(post);
    }

    public Post getPostById(Long postId){
        return finderId.findById(postRepository, postId, "Post");
    }


}
