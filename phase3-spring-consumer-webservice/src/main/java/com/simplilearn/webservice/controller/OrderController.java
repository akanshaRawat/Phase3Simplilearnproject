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

import com.simplilearn.webservice.entity.Order;
import com.simplilearn.webservice.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	
	@Autowired
	
	OrderRepository oRepo;
	
	//list product
		@GetMapping("orders")
		public List<Order> getOrders(){
			return oRepo.findAll();
			
		}
		//get one product
		@GetMapping("/orders/{id}")
		public Order getOrders(@PathVariable("id") long id){
			
			
			return oRepo.findById(id).get();
			
		}
		
		//add product
		@PostMapping("/orders")
		public Order addOrder(@RequestBody Order orderObj){
			
			 return oRepo.save(orderObj);
			
		}
		
		//update product
		
		@PutMapping("/orders")
		public Order updateOrder(@RequestBody Order orderObj) {
			
		Order fetchedOrder=oRepo.findById(orderObj.getId()).get();
		if(fetchedOrder!=null) {
			fetchedOrder.setName(orderObj.getName());
			//fetchedOrder.setRole(orderObj.getRole());
			
			return oRepo.save(fetchedOrder);
		}
		return null;
			
		}
		
		//delete product
		@DeleteMapping("/orders/{id}")
		public Order deleteOrder(@PathVariable("id") long id) {
			
			Order fetchedOrder =oRepo.findById(id).get();
			if(fetchedOrder != null) {
				oRepo.delete(fetchedOrder);
					
			}
			
		
			return null;
			
		}
	
}
