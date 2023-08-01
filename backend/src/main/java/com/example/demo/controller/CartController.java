package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.entity.Cart;
import com.example.demo.service.BookService;
import com.example.demo.service.CartService;

@CrossOrigin
@Controller
public class CartController {
	@Autowired
	private CartService service;
	@Autowired
	private BookService bookService;
	
	@ResponseBody
	@GetMapping("/carts/{username}")
	public List<Cart> findCart(@PathVariable String username) {
		return service.findCart(username);
	}
	
	
	@ResponseBody
	@PostMapping("/cart/0")
	public String addOneCart(@RequestBody Cart l) {
		service.addOneCart(l);
		return "Da them gio hang" ;
		
	}
	
	@ResponseBody
	@PutMapping("/cart/{id}") 
	public String saveOneLap(@PathVariable int id, @RequestBody Cart l) {
		
		   Cart oL = service.getOnecart(id);
			oL.setUsername(l.getUsername());
			oL.setIdbook(l.getIdbook());
			oL.setTensach(l.getTensach());
			oL.setSoluong(l.getSoluong());
			
			service.saveOneCart(oL);
			return "Ban da update thanh cong" ;
		
	}
	
	@ResponseBody
	@DeleteMapping("/carts/delete/{id}")
	public String removeCmt(@PathVariable int id) {
		try {
			service.removeCart(id);
			return "Ban da xoa thanh cong";
			
		} catch (Exception e) {
			return "Co loi da xay ra !!!";
		}
	}
	
	@ResponseBody
	@DeleteMapping("/carts/checkout/all")
	public String removeCmt(@RequestBody List<Cart> lc) {
		System.out.println(lc.get(0).getTensach());
		for(int i = 0; i< lc.size(); i++) {
			Book book = bookService.getOneBook(lc.get(i).getIdbook());
			book.setSoluong(lc.get(i).getSoluong()+ book.getSoluong());
			bookService.saveOneLap(book);
		}
		service.removeallCart();
		return "Ban da thanh toan thanh cong";
		
	}
	
	
}