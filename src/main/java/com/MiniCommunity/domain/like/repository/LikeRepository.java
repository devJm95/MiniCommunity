package com.MiniCommunity.domain.like.repository;

import com.MiniCommunity.domain.like.entity.Likes;
import com.MiniCommunity.domain.post.entity.Post;
import com.MiniCommunity.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    boolean existsByPostAndUser(Post post, User user);
    Optional<Likes> findByPostAndUser(Post post, User user);
    long countByPostId(Long postId);
}
