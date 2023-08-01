package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repo;
	
	public List<Book> getAll() {
		return repo.findAll();
	}
	
	public Book getOneBook(int id) {
		return repo.findById(id).get();
	}
	
	public Optional<Book> getBook(int id) {
		return repo.findById(id);
	}
	
	public void addOneBook(Book l) {
		repo.save(l);
	}
	
	public void saveOneLap(Book l) {
		repo.save(l);
	}
	
	public void removeLaptop(int id) {
		repo.deleteById(id);
	}
	
	public List<Book> findBook(String tieude, String tacgia) {
		return repo.findBook(tieude, tacgia);
	}
	
}