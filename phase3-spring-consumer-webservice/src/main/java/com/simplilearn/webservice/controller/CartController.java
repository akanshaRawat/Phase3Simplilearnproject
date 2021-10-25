package com.simplilearn.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Cart;
import com.simplilearn.webservice.repository.CartRepository;

@RestController
@RequestMapping("/api")
public class CartController {
	
	
	@Autowired
	
	CartRepository cRepo;
	
	//list product
		@GetMapping("/carts")
		public List<Cart> getCarts(){
			return cRepo.findAll();
			
		}
		//get one product
		@GetMapping("/carts/{id}")
		public Cart getCarts(@PathVariable("id") long id){
			
			
			return cRepo.findById(id).get();
			
		}
		
		//add product
		@PostMapping("/carts")
		public Cart addCart(@RequestBody Cart cartObj){
			
			 return cRepo.save(cartObj);
			
		}
		
		//update product
		
		@PutMapping("/carts")
		public Cart updateCart(@RequestBody Cart cartObj) {
			
		Cart fetchedCart=cRepo.findById(cartObj.getId()).get();
		if(fetchedCart!=null) {
			fetchedCart.setName(cartObj.getName());
		//	fetchedUser.setRole(userObj.getRole());
			
			return cRepo.save(fetchedCart);
		}
		return null;
			
		}
		
		//delete product
		@DeleteMapping("/carts/{id}")
		public Cart deleteUser(@PathVariable("id") long id) {
			
			Cart fetchedCart =cRepo.findById(id).get();
			if(fetchedCart != null) {
				cRepo.delete(fetchedCart);
					
			}
			
		
			return null;
			
		}
	
	

	
}
