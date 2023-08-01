package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select l From User l Where l.username = ?1")
	public List<User> findUser(String username);
	
	@Query("select l From User l Where l.username = ?1 and l.password = ?2")
	public User findByUser(String username, String password);
}
