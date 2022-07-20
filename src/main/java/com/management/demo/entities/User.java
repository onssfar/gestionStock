package com.management.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	private String firstName;
	
	private String lastName;

	private String username;
	
	private String email;
	
	private String password;
	
	private int phoneNumber ;
	
	@OneToMany
	@JoinColumn(name = "idBill")
	private List<Bill> bill;
}
