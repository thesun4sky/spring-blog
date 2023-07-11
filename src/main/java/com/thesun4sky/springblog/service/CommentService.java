package com.thesun4sky.springblog.service;

import com.thesun4sky.springblog.dto.CommentRequestDto;
import com.thesun4sky.springblog.dto.CommentResponseDto;
import com.thesun4sky.springblog.entity.Comment;
import com.thesun4sky.springblog.entity.User;

public interface CommentService {

	/**
	 * 댓글 생성
	 * @param requestDto 댓글 생성 요청정보
	 * @param user 댓글 생성 요청자
	 * @return 생성된 댓글 정보
	 */
	CommentResponseDto createComment(CommentRequestDto requestDto, User user);

	/**
	 * 댓글 수정
	 * @param comment
	 * @param requestDto
	 * @param user
	 * @return
	 */
	CommentResponseDto updateComment(Comment comment, CommentRequestDto requestDto, User user);

	void deleteComment(Comment comment, User user);

	void likeComment(Long id, User user);

	void deleteLikeComment(Long id, User user);

	Comment findComment(long id);
}
