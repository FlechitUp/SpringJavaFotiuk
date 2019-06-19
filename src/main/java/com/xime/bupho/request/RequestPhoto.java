package com.xime.bupho.request;

public class RequestPhoto {
	
	private Long id;
	private String name;
	private Integer price;
	private Long userid;
	
	public RequestPhoto(Long id, Long userid, String name, Integer price) {
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.price = price;
	}
	
	public RequestPhoto() {
		
	}
	
	public Long getUserId() {
		return this.userid;
	}
	
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
		  
	public Integer getPrice() {
		return price;
	}
	 
	 public void setPrice(Integer price) {
		 this.price = price;
	 }
		 
}
