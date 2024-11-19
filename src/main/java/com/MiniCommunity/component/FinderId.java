package com.MiniCommunity.component;

import com.MiniCommunity.entity.post.Post;
import com.MiniCommunity.entity.user.User;
import com.MiniCommunity.repository.post.PostRepository;
import com.MiniCommunity.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FinderId {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

//    public Post findPostById(Long postId) {
//        return postRepository.findById(postId)
//                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + postId));
//    }
//
//    public User findUserById(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//    }

    public <T> T findById(JpaRepository<T, Long> repository, Long id, String resourceName) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(resourceName + " not found with ID: " + id));
    }

}
