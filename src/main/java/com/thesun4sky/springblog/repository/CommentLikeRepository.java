package com.thesun4sky.springblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesun4sky.springblog.entity.Comment;
import com.thesun4sky.springblog.entity.CommentLike;
import com.thesun4sky.springblog.entity.Post;
import com.thesun4sky.springblog.entity.PostLike;
import com.thesun4sky.springblog.entity.User;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
	Optional<CommentLike> findByUserAndComment(User user, Comment comment);
	Boolean existsByUserAndComment(User user, Comment comment);
}
