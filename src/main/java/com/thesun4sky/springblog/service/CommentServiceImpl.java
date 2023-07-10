package com.thesun4sky.springblog.service;

import java.util.Optional;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jdi.request.DuplicateRequestException;
import com.thesun4sky.springblog.dto.CommentRequestDto;
import com.thesun4sky.springblog.dto.CommentResponseDto;
import com.thesun4sky.springblog.entity.Comment;
import com.thesun4sky.springblog.entity.CommentLike;
import com.thesun4sky.springblog.entity.Post;
import com.thesun4sky.springblog.entity.User;
import com.thesun4sky.springblog.entity.UserRoleEnum;
import com.thesun4sky.springblog.repository.CommentLikeRepository;
import com.thesun4sky.springblog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final PostServiceImpl postService;
    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;

    @Override
    public CommentResponseDto createComment(CommentRequestDto requestDto, User user) {
        Post post = postService.findPost(requestDto.getPostId());
        Comment comment = new Comment(requestDto.getBody());
        comment.setUser(user);
        comment.setPost(post);

        var savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }

    @Override
    public void deleteComment(Long id, User user) {
        Comment comment = commentRepository.findById(id).orElseThrow();

        // 요청자가 운영자 이거나 댓글 작성자(post.user) 와 요청자(user) 가 같은지 체크
        if (!user.getRole().equals(UserRoleEnum.ADMIN) && !comment.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }

        commentRepository.delete(comment);
    }

    @Override
    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto requestDto, User user) {
        Comment comment = commentRepository.findById(id).orElseThrow();

        // 요청자가 운영자 이거나 댓글 작성자(post.user) 와 요청자(user) 가 같은지 체크
        if (!user.getRole().equals(UserRoleEnum.ADMIN) && !comment.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }

        comment.setBody(requestDto.getBody());

        return new CommentResponseDto(comment);
    }

    @Override
    @Transactional
    public void likeComment(Long id, User user) {
        Comment comment = findComment(id);

        if (commentLikeRepository.existsByUserAndComment(user, comment)) {
            throw new DuplicateRequestException("이미 좋아요 한 댓글 입니다.");
        } else {
            CommentLike commentLike = new CommentLike(user, comment);
            commentLikeRepository.save(commentLike);
        }
    }
    @Override
    @Transactional
    public void dislikeComment(Long id, User user) {
        Comment comment = findComment(id);
        Optional<CommentLike> commentLikeOptional = commentLikeRepository.findByUserAndComment(user, comment);
        if (commentLikeOptional.isPresent()) {
            commentLikeRepository.delete(commentLikeOptional.get());
        } else {
            throw new IllegalArgumentException("해당 댓글에 취소할 좋아요가 없습니다.");
        }
    }

    @Override
    public Comment findComment(long id) {
        return commentRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }
}
