package com.event.booking.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "events")

	private Set<User> users = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="eventImage")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Image >images;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="eventComment")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Comment> eventComments;
	
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

	

	/*public Comment getEventComment() {
		return eventComment;
	}

	public void setEventComment(Comment eventComment) {
		this.eventComment = eventComment;
	}*/
	
	

	public Set<User> getUsers() {
		return users;
	}



	public void setUsers(Set<User> users) {
		this.users = users;
	}



	public List<Image> getImages() {
		return images;
	}



	public void setImages(List<Image> images) {
		this.images = images;
	}



	public List<Comment> getEventComments() {
		return eventComments;
	}



	public void setEventComments(List<Comment> eventComments) {
		this.eventComments = eventComments;
	}



	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", reference=" + reference + ", lat=" + lat + ", longe=" + longe + ", users=" + users + ", images="
				+ images + ", eventComments=" + eventComments + "]";
	}









}
