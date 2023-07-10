package com.thesun4sky.springblog.service;

import com.thesun4sky.springblog.dto.CommentRequestDto;
import com.thesun4sky.springblog.dto.CommentResponseDto;
import com.thesun4sky.springblog.entity.Comment;
import com.thesun4sky.springblog.entity.User;

public interface CommentService {
	CommentResponseDto createComment(CommentRequestDto requestDto, User user);

	CommentResponseDto updateComment(Long id, CommentRequestDto requestDto, User user);

	void deleteComment(Long id, User user);

	void likeComment(Long id, User user);

	void dislikeComment(Long id, User user);

	Comment findComment(long id);
}
