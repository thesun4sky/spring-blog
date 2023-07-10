package com.thesun4sky.springblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesun4sky.springblog.entity.Post;
import com.thesun4sky.springblog.entity.PostLike;
import com.thesun4sky.springblog.entity.User;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
	Boolean existsByUserAndPost(User user, Post post);
}
