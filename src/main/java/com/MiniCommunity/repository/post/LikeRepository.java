package com.MiniCommunity.repository.post;

import com.MiniCommunity.entity.post.Likes;
import com.MiniCommunity.entity.post.Post;
import com.MiniCommunity.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    boolean existsByPostAndUser(Post post, User user);
    Optional<Likes> findByPostAndUser(Post post, User user);
    long countByPostId(Long postId);
}
