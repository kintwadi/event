package com.event.booking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@MappedSuperclass
public class UserDetails {
	
	@Id
	@GeneratedValue
	private long userId;
	private String cellphone;
	private String country;
	private String city;
	private String street;
	
	
	@OneToMany(mappedBy ="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Event>events = new ArrayList<>();
	
	
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
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", cellphone=" + cellphone + ", country=" + country + ", city=" + city
				+ ", street=" + street + ", events=" + events + "]";
	}
	
	
	

	
	

	
	
	


	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
