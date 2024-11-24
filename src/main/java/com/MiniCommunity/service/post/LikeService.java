package com.MiniCommunity.service.post;

import com.MiniCommunity.component.FinderId;
import com.MiniCommunity.entity.post.Likes;
import com.MiniCommunity.entity.post.Post;
import com.MiniCommunity.entity.user.User;
import com.MiniCommunity.repository.post.LikeRepository;
import com.MiniCommunity.repository.post.PostRepository;
import com.MiniCommunity.repository.user.UserRepository;
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
