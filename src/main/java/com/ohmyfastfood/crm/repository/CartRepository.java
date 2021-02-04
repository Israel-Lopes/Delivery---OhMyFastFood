package com.ohmyfastfood.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ohmyfastfood.crm.model.CartModel;

public interface CartRepository extends JpaRepository<CartModel, Long>{

}
