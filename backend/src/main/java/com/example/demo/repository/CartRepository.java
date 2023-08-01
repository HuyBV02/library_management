package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query("select l From Cart l Where l.username = ?1")
	public List<Cart> findCart(String username);
	
//	@Query("delete From Cart l where l.username=?1")
//	public void deleteCart(String username);
}
