package com.thesun4sky.springblog.service;

import com.thesun4sky.springblog.dto.PostListResponseDto;
import com.thesun4sky.springblog.dto.PostRequestDto;
import com.thesun4sky.springblog.dto.PostResponseDto;
import com.thesun4sky.springblog.entity.Post;
import com.thesun4sky.springblog.entity.User;

public interface PostService {
	/**
	 * 게시글 생성
	 * @param requestDto 게시글 생성 요청정보
	 * @param user 게시글 생성 요청자
	 * @return 게시글 생성 결과
	 */
	PostResponseDto createPost(PostRequestDto requestDto, User user);

	/**
	 * 전체 게시글 목록 조회
	 * @return 전체 게시글 목록
	 */
	PostListResponseDto getPosts();

	/**
	 * 게시글 단건 조회
	 * @param id 조회할 게시글 ID
	 * @return 조회된 게시글 정보
	 */
	PostResponseDto getPostById(Long id);

	/**
	 * 게시글 업데이트
	 * @param post 업데이트 할 게시글
	 * @param requestDto 업데이트 할 게시글 정보
	 * @param user 게시글 업데이트 요청자
	 * @return 업데이트된 게시글 정보
	 */
	PostResponseDto updatePost(Post post, PostRequestDto requestDto, User user);

	/**
	 * 게시글 삭제
	 * @param id 삭제 요청 게시글 ID
	 * @param user 게시글 삭제 요청자
	 */
	void deletePost(Long id, User user);

	/**
	 * 게시글 좋아요
	 * @param id 좋아요 요청 게시글 ID
	 * @param user 게시글 좋아요 요청자
	 */
	void likePost(Long id, User user);

	/**
	 * 게시글 좋아요 취소
	 * @param id 좋아요 취소 요청 게시글 ID
	 * @param user 게시글 좋아요 취소 요청자
	 */
	void dislikePost(Long id, User user);

	/**
	 * 게시글 Entity 단건 조회
	 * @param id 조회할 게시글 ID
	 * @return 게시글 Entity
	 */
	Post findPost(long id);
}
