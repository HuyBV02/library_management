package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Star;
import com.example.demo.repository.StarRepository;

@Service
public class StarService {
	@Autowired
	private StarRepository repo;
	
	
	public List<Star> getStar(String username, int idbook) {
		
		return  repo.findStar(username, idbook);
	}
	
public List<Star> findAll() {
		
		return  repo.findAll();
	}
	
	public void saveAllStars(List<Star> ls) {
		repo.deleteAll();
		repo.saveAll(ls);
	}
	
	public Star getOneStar (int id) {
		return repo.findById(id).get();
	}
	
	public void addOneStar(Star l) {
		repo.save(l);
	}
}
