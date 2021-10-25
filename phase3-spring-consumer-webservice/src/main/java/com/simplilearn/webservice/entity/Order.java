package com.simplilearn.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class Order {
	@Id
	@GeneratedValue(generator="increment")
	@Column(name="order_id")
	private long id;
	
	@Column(name="order_name")
	private String name;
	
//	@Column(name="user_role")
//	@Enumerated(EnumType.STRING)
	//private String role;
	
	
	public Order() {
		super();
	}


	public Order(long id, String name) {
		super();
		this.id = id;
		this.name = name;
//		this.role = role;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


//	public String getRole() {
//		return role;
//	}
//
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
