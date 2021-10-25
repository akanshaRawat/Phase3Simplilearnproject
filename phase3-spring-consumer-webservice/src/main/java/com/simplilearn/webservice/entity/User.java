package com.simplilearn.webservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.simplilearn.webservice.entity.Product;

@Entity
@Table(name="user_details")
public class User {
	@Id
	@GeneratedValue(generator="increment")
	@Column(name="user_id")
	private long userId;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_role")

	private String role;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="product_name")
	private Product product;
	
	
	
	public User() {
		super();
	}


	public User(long userId, String name, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
	}


	public long getuserId() {
		return userId;
	}


	public void setuserId(long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
}
