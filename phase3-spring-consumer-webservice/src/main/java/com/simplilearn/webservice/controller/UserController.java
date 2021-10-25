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

import com.simplilearn.webservice.entity.Product;
import com.simplilearn.webservice.entity.User;
import com.simplilearn.webservice.repository.ProductRepository;
import com.simplilearn.webservice.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	
	@Autowired
	
	UserRepository uRepo;
	
	
	
	//list product
		@GetMapping("/users")
		public List<User> getUsers(){
			return uRepo.findAll();
			
		}
		//get one product
		@GetMapping("/users/{userId}")
		public User getUsers(@PathVariable("userId") long userId){
			
			
			return uRepo.findById(userId).get();
			
		}
		
		//add product
		@PostMapping("/users")
		public User addUser(@RequestBody User userObj){
			
			 return uRepo.save(userObj);
			
		}
		
		
		//update product
		
		@PutMapping("/users")
		public User updateUser(@RequestBody User userObj) {
			
		User fetchedUser=uRepo.findById(userObj.getuserId()).get();
		if(fetchedUser!=null) {
			fetchedUser.setName(userObj.getName());
			fetchedUser.setRole(userObj.getRole());
			
			return uRepo.save(fetchedUser);
		}
		return null;
			
		}
		
		//delete product
		@DeleteMapping("/users/{userId}")
		public User deleteUser(@PathVariable("userId") long userId) {
			
			User fetchedUser =uRepo.findById(userId).get();
			if(fetchedUser != null) {
				uRepo.delete(fetchedUser);
					
			}
			
		
			return null;
			
		}
	
	

	
}
