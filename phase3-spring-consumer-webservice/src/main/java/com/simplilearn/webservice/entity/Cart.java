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
@Table(name="cart_details")
public class Cart {
	@Id
	@GeneratedValue(generator="increment")
	@Column(name="Cart_id")
	private long id;
	
	@Column(name="cart_name")
	private String name;
	

	
	
	public Cart() {
		super();
	}


	public Cart(long id, String name) {
		super();
		this.id = id;
		this.name = name;

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




	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
