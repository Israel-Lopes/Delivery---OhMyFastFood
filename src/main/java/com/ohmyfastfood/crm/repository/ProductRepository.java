package com.ohmyfastfood.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohmyfastfood.crm.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{

}
