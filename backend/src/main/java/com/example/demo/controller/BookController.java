package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@CrossOrigin
@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/books")
	public List<Book> getLapTopsList() {
		return service.getAll();
	}
	
	@ResponseBody
	@GetMapping("/book/{id}")
	public Book getOneBook(@PathVariable int id) {
		return service.getOneBook(id);
	}
	
	@ResponseBody
	@PostMapping("/book/0")
	public String addOneBook(@RequestBody Book l) {
		List<Book> exitL = service.findBook(l.getTieude(), l.getTacgia());
		if (!exitL.isEmpty()) {
			return "Sách " + l.getTieude() + " va tác giả " + l.getTacgia() + " da ton tai! Vui long nhap lai";
		} else {
			service.addOneBook(l);
			return "Ban da add thanh cong sach: " + l.getTieude();
		}
	}
	
	@ResponseBody
	@PutMapping("/book/{id}") 
	public String saveOneLap(@PathVariable int id, @RequestBody Book l) {
		List<Book> exitL = service.findBook(l.getTieude(), l.getTacgia());
		if (exitL.size() == 1 && l.getId() != exitL.get(0).getId()) {
			return "Sach " + l.getTieude() + " va tac gia " + l.getTacgia() + " da ton tai! Vui long nhap lai";
		} else {
			Book oL = service.getOneBook(id);
			oL.setTieude(l.getTieude());
			oL.setTacgia(l.getTacgia());
			oL.setTheloai(l.getTheloai());
			oL.setNgayphathanh(l.getNgayphathanh());
			oL.setSotrang(l.getSotrang());
			oL.setSoluong(l.getSoluong());
			oL.setImg(l.getImg());
			oL.setMieuta(l.getMieuta());
			oL.setDanhgia(l.getDanhgia());
			service.saveOneLap(oL);
			return "Ban da update thanh cong Sach: " + l.getTieude();
		}
	}
	
	@ResponseBody
	@DeleteMapping("/books/delete/{id}")
	public String removeStudent(@PathVariable int id) {
		try {
			service.removeLaptop(id);
			return "Ban da xoa thanh cong " + String.valueOf(id);
		} catch (Exception e) {
			return "Co loi da xay ra !!!";
		}
	}
	

	
	
}