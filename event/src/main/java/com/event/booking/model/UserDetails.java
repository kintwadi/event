package com.event.booking.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class UserDetails {
	
	@Id
	@GeneratedValue
	private long userId;
	private String cellphone;
	private String country;
	private String city;
	private String street;
	
	@OneToMany(mappedBy="userComment")
	private List<Comment >comment;
	
	public UserDetails(long userId, String cellphone, String country, String city, String street) {
		super();
		this.userId = userId;
		this.cellphone = cellphone;
		this.country = country;
		this.city = city;
		this.street = street;
	}
	public UserDetails() {
	
	}
	public long getId() {
		return userId;
	}
	public void setId(long userId) {
		this.userId = userId;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
	
	
	
	
	
}
