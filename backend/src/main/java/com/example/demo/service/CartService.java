package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository repo;
	
	public List<Cart> findCart(String username) {
		return repo.findCart(username);
	}
	public void addOneCart(Cart l) {
		repo.save(l);
	}
	
	public void saveOneCart(Cart l) {
		repo.save(l);
	}
	
	public void removeCart(int id) {
		repo.deleteById(id);
	}
	
	public void removeallCart() {
		
		repo.deleteAll();
		
		
	}

	public Cart getOnecart(int id) {
		return repo.findById(id).get();
	}
}
