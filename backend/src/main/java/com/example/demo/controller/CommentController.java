package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;

@CrossOrigin
@Controller
public class CommentController {
	@Autowired
	private CommentService service;
	
	@ResponseBody
	@GetMapping("/cmts/{idbook}")
	public List<Comment> findComment(@PathVariable int idbook) {
		return service.findComment(idbook);
	}
	
	
	@ResponseBody
	@PostMapping("/cmt/0")
	public String addOneBook(@RequestBody Comment l) {
		service.addOneComment(l);
		return "Da gui cmt" ;
		
	}
	@ResponseBody
	@DeleteMapping("/cmts/delete/{id}")
	public String removeCmt(@PathVariable int id) {
		try {
			service.removeComment(id);
			return "Ban da xoa thanh cong";
		} catch (Exception e) {
			return "Co loi da xay ra !!!";
		}
	}
	
}
	