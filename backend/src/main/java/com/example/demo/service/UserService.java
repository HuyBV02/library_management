package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<User> getAll() {
		return repo.findAll();
	}
	
	public User getOneUser(int id) {
		return repo.findById(id).get();
	}
	
	public void addOneUser(User l) {
		
		l.setRole("USER");
		repo.save(l);
	}
	
	public void saveOneUser(User l) {
		repo.save(l);
	}
	
	public void removeUser(int id) {
		repo.deleteById(id);
	}
	
	public List<User> findUser(String username) {
		return repo.findUser(username);
	}
	
	public User findByUsername(String username, String password) {
		return repo.findByUser(username, password);
	}
	

}
