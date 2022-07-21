package com.management.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data

public class Bill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBill;

	private Date declarationDate;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	@ManyToMany
	@JoinColumn(name = "idProduct")
	private List<Product> produts;

	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;

	public Long getIdBill() {
		return idBill;
	}

	public void setIdBill(Long idBill) {
		this.idBill = idBill;
	}

	public Date getDeclarationDate() {
		return declarationDate;
	}

	public void setDeclarationDate(Date declarationDate) {
		this.declarationDate = declarationDate;
	}

	public List<Product> getProduts() {
		return produts;
	}

	public void setProduts(List<Product> produts) {
		this.produts = produts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
