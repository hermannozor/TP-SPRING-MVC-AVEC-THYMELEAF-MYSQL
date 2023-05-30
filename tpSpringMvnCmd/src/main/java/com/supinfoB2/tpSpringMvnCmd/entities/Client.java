package com.supinfoB2.tpSpringMvnCmd.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@jakarta.persistence.GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty
	@Size(min=5,max=30)
	private String nom;
	

	@Column(nullable = false)
	private String prenom;
	

	@Column(nullable = false)
	private String adresse;
	

	@Column(nullable = false)
	private String telephone;
	

	@Column(nullable = false)
	@NotEmpty
	private String email;


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(String nom, String prenom, String adresse, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
