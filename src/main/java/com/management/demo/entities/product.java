package com.management.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data

public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduct;
	
	private int code;
	
	private String reference;
	
	private String productName;
	
	private String shortLabel;

	private Date expirationDate;
	
	private Date productionDate;

	private float unitPrice;
	
	private int quantity;
	
	private float totalPrice;
	
	private String category;
	
	private String description;
	
	

}
