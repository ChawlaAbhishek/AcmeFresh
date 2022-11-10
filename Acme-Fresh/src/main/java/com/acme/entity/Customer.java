package com.acme.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min=4,message="user name must be minimum of 4 characters")
	private String name;
	@Email(message = "Enter a valid email address")
	private String email;
	
	@Size(min=4,max=10,message="password length should be between 4 to 10 char")
	private String password;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	
	
	

}
