package com.MiniCommunity.domain.like.service;

import com.MiniCommunity.common.component.FinderId;
import com.MiniCommunity.domain.like.entity.Likes;
import com.MiniCommunity.domain.post.entity.Post;
import com.MiniCommunity.domain.user.entity.User;
import com.MiniCommunity.domain.like.repository.LikeRepository;
import com.MiniCommunity.domain.post.repository.PostRepository;
import com.MiniCommunity.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final FinderId finderId;

    @Transactional
    public void likePost(Long postId, Long userId){
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new RuntimeException("Post not found"));
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = finderId.findById(postRepository, postId, "Post");
        User user = finderId.findById(userRepository, userId, "User");

        if (likeRepository.existsByPostAndUser(post, user)){
            throw new RuntimeException("Already liked");
        }

        Likes like = new Likes();
        like.setPost(post);
        like.setUser(user);
        likeRepository.save(like);
    }

    @Transactional
    public void unlikePost(Long postId, Long userId){

        Post post = finderId.findById(postRepository, postId, "Post");
        User user = finderId.findById(userRepository, userId, "User");

        Likes like = likeRepository.findByPostAndUser(post, user)
                .orElseThrow(() -> new RuntimeException("Like not found"));

        likeRepository.delete(like);
    }

    @Transactional
    public long countLikes(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}
