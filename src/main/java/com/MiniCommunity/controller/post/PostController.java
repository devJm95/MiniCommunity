package com.MiniCommunity.controller.post;

import com.MiniCommunity.dto.post.PostDTO;
import com.MiniCommunity.entity.post.Post;
import com.MiniCommunity.service.post.LikeService;
import com.MiniCommunity.service.post.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "PostApi")
@RequestMapping("/api/posts")
public class PostController {

    private final LikeService likeService;
    private final PostService postService;

    @PostMapping

    public ResponseEntity<Post> saveOrUpdatePost(@RequestBody PostDTO postDTO, @RequestParam Long userId{
        Post post = postService.saveOrUpdatePost(postDTO, userId);
        return ResponseEntity.ok(post);
    }


    @PostMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable Long postId, @RequestParam Long userId){
        likeService.likePost(postId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}/like")
    public ResponseEntity<?> unlikePost(@PathVariable Long postId, @RequestParam Long userId){
        likeService.unlikePost(postId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}/likes")
    public ResponseEntity<Long> getLikeCount(@PathVariable Long postId){
        long count = likeService.countLikes(postId);
        return ResponseEntity.ok(count);
    }
}

