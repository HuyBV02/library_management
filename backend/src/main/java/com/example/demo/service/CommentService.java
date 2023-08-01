package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Comment;

import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repo;
		
	public List<Comment> getAll() {
		return repo.findAll();
	}
	
	public void addOneComment(Comment l) {
		repo.save(l);
	}
	
	public void saveOneComment(Comment l) {
		repo.save(l);
	}
	
	public void removeComment(int id) {
		repo.deleteById(id);
	}
	
	public List<Comment> findComment(int idbook) {
		return repo.findComment(idbook);
	}
}
