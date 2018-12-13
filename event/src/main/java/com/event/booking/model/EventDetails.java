package com.event.booking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@MappedSuperclass
public class EventDetails {
	
	@Id
	@GeneratedValue
	private long eventId;
	private String country;
	private String city;
	private String street;
	private String reference;
	private double lat;
	private double longe; 
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	                                                            
	@OneToMany(mappedBy ="event", fetch=FetchType.EAGER, cascade=CascadeType.ALL)      
	@Fetch(value = FetchMode.SUBSELECT)                                               
	private List<Comment>comments = new ArrayList<>();                                
	
	                                                            
	@OneToMany(mappedBy ="event", fetch=FetchType.EAGER, cascade=CascadeType.ALL)      
	@Fetch(value = FetchMode.SUBSELECT)                                               
	private List<Image>images = new ArrayList<>();  
    
	public EventDetails() {
		
	}
	
	

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLonge() {
		return longe;
	}

	public void setLonge(double longe) {
		this.longe = longe;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", reference=" + reference + ", lat=" + lat + ", longe=" + longe + ", user=" + user + ", comments="
				+ comments + ", images=" + images + "]";
	}
	
	



	







}
