package com.thesun4sky.springblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesun4sky.springblog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
