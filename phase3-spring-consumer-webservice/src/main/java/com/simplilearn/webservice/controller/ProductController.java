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
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	
	@Autowired
	
	ProductRepository pRepo;
	
	//list product
		@GetMapping("/products")
		public List<Product> getProducts(){
			return pRepo.findAll();
			
		}
		//get one product
		@GetMapping("/products/{id}")
		public Product getProducts(@PathVariable("id") long id){
			
			
			return pRepo.findById(id).get();
			
		}
		
		//add product
		@PostMapping("/products")
		public Product addProduct(@RequestBody Product productObj){
			
			 return pRepo.save(productObj);
			
		}
		
		//update product
		
		@PutMapping("/products")
		public Product updateProduct(@RequestBody Product productObj) {
			
		Product fetchedProduct=pRepo.findById(productObj.getId()).get();
		if(fetchedProduct!=null) {
			fetchedProduct.setName(productObj.getName());
			fetchedProduct.setPrice(productObj.getPrice());
			
			return pRepo.save(fetchedProduct);
		}
		return null;
			
		}
		
		//delete product
		@DeleteMapping("/products/{id}")
		public Product deleteProduct(@PathVariable("id") long id) {
			
			Product fetchedProduct =pRepo.findById(id).get();
			if(fetchedProduct != null) {
				pRepo.delete(fetchedProduct);
					
			}
			
		
			return null;
			
		}
	
	

	
}
