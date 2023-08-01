package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Star;
import com.example.demo.service.StarService;

@Controller
@CrossOrigin
public class StarController {
	@Autowired
	private StarService service;
	
//	@ResponseBody
//	@GetMapping("/search/{username}/{idbook}")
//	public List<Star> findStar(@PathVariable String username, @PathVariable int idbook) {
//		return service.getStar(username, idbook);
//	}
	
	@ResponseBody
	@GetMapping("/search/{username}/{idbook}")
	public List<Star> findStar(@PathVariable String username, @PathVariable int idbook) {
		return service.findAll();
	}
	
	@ResponseBody
	@PostMapping("/star/0")
	public String addOneBook(@RequestBody Star l) {
		
			service.addOneStar(l);
			return "Ban da danh gia thanh cong ";
		
	}
	
	@ResponseBody
	@PutMapping("/star/all")
	public String changeStar(@RequestBody List<Star> ls) {
		
		service.saveAllStars(ls);
		return "Đánh giá thành công!";
	}
}
