package com.ohmyfastfood.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohmyfastfood.crm.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
