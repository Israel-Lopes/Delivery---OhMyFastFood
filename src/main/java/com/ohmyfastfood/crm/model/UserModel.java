package com.ohmyfastfood.crm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String cpf;

	/**
	 * @Description (Only admins will have true,
	 * 	so it is not mandatory in the request body)
	 * */
	private Boolean isAdmin = false;

	@OneToOne(cascade = CascadeType.ALL)
	private PaymentModel typePayment;
}
