package com.xime.bupho.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class UserModel {

	@Id
	@GeneratedValue(generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "mail", unique = true)
	private String mail;

	@Column(name = "password")
	private String password;
	
	@OneToMany//(mappedBy = "user")//(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PhotoModel> photos;
	
	/*@OneToMany(mappedBy = "user")
	private List<PurchaseModel> purchases;
	
	@OneToMany(mappedBy = "user")
	private List<SaleModel> sales;*/
	
	public UserModel() {
		this.photos = new ArrayList<>();
		/*this.purchases = new ArrayList<>();
		this.sales = new ArrayList<>();*/
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<PhotoModel> getPhotos(){
		return photos;
	}
	
	public void setPhoto(PhotoModel photo) {
		this.photos.add(photo);
	}
	
	/*public List<PurchaseModel> getPurchases(){
		return purchases;
	}
	
	public void setPurchase(PurchaseModel purchase) {
		this.purchases.add(purchase);
	}
	
	public List<SaleModel> getSales(){
		return sales;
	}
	
	public void setSale(SaleModel sale) {
		this.sales.add(sale);
	}*/
}
