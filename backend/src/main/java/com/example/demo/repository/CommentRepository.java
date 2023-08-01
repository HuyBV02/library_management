package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	@Query("select l From Comment l Where l.idbook = ?1")
	public List<Comment> findComment(int idbook);
}
