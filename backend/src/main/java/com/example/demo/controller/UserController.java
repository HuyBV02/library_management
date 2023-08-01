package com.example.demo.controller;

import java.util.List;


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

import com.example.demo.entity.User;

import com.example.demo.service.UserService;


@CrossOrigin
@Controller
public class UserController {
	@Autowired
	private UserService service;
	

	
	@ResponseBody
	@GetMapping("/users")
	public List<User> getUsersList() {
		return service.getAll();
	}
	
	@ResponseBody
	@GetMapping("/user/{id}")
	public User getOneUser(@PathVariable int id) {
		return service.getOneUser(id);
	}
		
	@ResponseBody
	@PostMapping("/save/0")
	public ResponseEntity<?> addOneUser(@RequestBody User l) {
		List<User> exitL = service.findUser(l.getUsername());
		if (!exitL.isEmpty()) {
			return ResponseEntity.status(400).body("Tài khoản " + l.getUsername() + " da ton tai! Vui long nhap lai");
		} else {
			service.addOneUser(l);
			return ResponseEntity.ok("Đăng kí thành công tài khoản: " + l.getUsername());
		}
	}
	
	@ResponseBody
	@PutMapping("/save/{id}") 
	public String saveOneUser(@PathVariable int id, @RequestBody User l) {
		List<User> exitL = service.findUser(l.getUsername());
		if (exitL.size() == 1 && l.getId() != exitL.get(0).getId()) {
			return "Tài khoản " + l.getUsername() +" da ton tai! Vui long nhap lai";
		} else {
			User oL = service.getOneUser(id);
			oL.setFullname(l.getFullname());
			oL.setUsername(l.getUsername());
			oL.setPassword(l.getPassword());
//			oL.setGiohang(l.getGiohang());
			oL.setRole(l.getRole());
			
			service.saveOneUser(oL);
			return "Ban da update thanh cong Sach: " + l.getUsername();
		}
	}
	
	
//	// save cart
//		@ResponseBody
//		@PutMapping("/save/cart")
//		public ResponseEntity<?> updateCart(@RequestBody User u) {
//			List<User> lU = service.findUser(u.getUsername());
//			if (lU.size() == 1) {
//				lU.get(0).setGiohang(u.getGiohang());
//				service.saveOneUser(lU.get(0));
//				return ResponseEntity.ok("Đã cập nhật thành công Giỏ hàng của User " + u.getUsername());
//			}
//			return ResponseEntity.status(400).body("Cập nhật giỏ hàng thất bại!");
//			
//		}
//		
//		// pay cart
//		@ResponseBody
//		@PutMapping("/user/pay/cart")
//		public ResponseEntity<?> payCart(@RequestBody User u) {
//			List<User> lU = service.findUser(u.getUsername());
//			if (lU.size() == 1) {
//				lU.get(0).setGiohang("[]");
//				service.saveOneUser(lU.get(0));
//				return ResponseEntity.ok("Bạn đã thanh toán thành công!");
//			}
//			return ResponseEntity.status(400).body("Thanh toán thất bại!");	
//		}
	
	
	@ResponseBody
	@DeleteMapping("/users/delete/{id}")
	public String removeUser(@PathVariable int id) {
		try {
			service.removeUser(id);
			return "Ban da xoa thanh cong tai khoan " + String.valueOf(id);
		} catch (Exception e) {
			return "Co loi da xay ra !!!";
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User u) {
		User exitL = service.findByUsername(u.getUsername(), u.getPassword());
		if(exitL==null) {
			return ResponseEntity.status(400).body("Thông tin tài khoản không chính xác");
		}else {
			
			
			return ResponseEntity.ok(exitL); 
		}
	}
	
	
	
}