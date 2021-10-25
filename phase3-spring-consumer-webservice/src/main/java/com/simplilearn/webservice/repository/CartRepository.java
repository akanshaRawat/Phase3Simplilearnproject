package com.simplilearn.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}

