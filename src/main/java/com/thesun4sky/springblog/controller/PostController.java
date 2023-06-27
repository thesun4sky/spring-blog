package com.thesun4sky.springblog.controller;

import com.thesun4sky.springblog.dto.ApiResponseDto;
import com.thesun4sky.springblog.dto.PostListResponseDto;
import com.thesun4sky.springblog.dto.PostRequestDto;
import com.thesun4sky.springblog.dto.PostResponseDto;
import com.thesun4sky.springblog.jwt.JwtUtil;
import com.thesun4sky.springblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final JwtUtil jwtUtil;

    @PostMapping("/posts")
    public ResponseEntity<PostResponseDto> createPost(@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String data, @RequestBody PostRequestDto requestDto) {
        jwtUtil.doubleCheckToken(data);
        PostResponseDto result = postService.createPost(requestDto);

        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostListResponseDto> getPosts() {
        PostListResponseDto result = postService.getPosts();

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id) {
        PostResponseDto result = postService.getPostById(id);

        return ResponseEntity.status(200).body(result);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String data, @PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        jwtUtil.doubleCheckToken(data);
        PostResponseDto result = postService.updatePost(id, requestDto);

        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<ApiResponseDto> deletePost(@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String data, @PathVariable Long id) {
        jwtUtil.doubleCheckToken(data);
        postService.deletePost(id);

        return ResponseEntity.status(200).body(new ApiResponseDto("게시글 삭제 성공", 200));
    }
}
