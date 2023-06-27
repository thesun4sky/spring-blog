package com.thesun4sky.springblog.repository;

import com.thesun4sky.springblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
