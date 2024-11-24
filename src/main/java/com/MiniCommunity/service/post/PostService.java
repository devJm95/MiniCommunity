package com.MiniCommunity.service.post;


import com.MiniCommunity.component.FinderId;
import com.MiniCommunity.dto.post.PostDTO;
import com.MiniCommunity.entity.post.Post;
import com.MiniCommunity.entity.user.User;
import com.MiniCommunity.repository.post.PostRepository;
import com.MiniCommunity.repository.user.UserRepository;
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
