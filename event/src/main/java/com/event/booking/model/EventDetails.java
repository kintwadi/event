package com.event.booking.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Temporal(TemporalType.DATE)
	private Date date;
	private String month;
	private String day;
	private String hour;
	private String minuts;
	private String seconds;
	private String start;
	private String end;
	private double price;
	private String currencyCode;
	
	@JsonIgnore
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



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public List<Image> getImages() {
		return images;
	}



	public void setImages(List<Image> images) {
		this.images = images;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getSeconds() {
		return seconds;
	}



	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	


	public String getHour() {
		return hour;
	}



	public void setHour(String hour) {
		this.hour = hour;
	}



	public String getMinuts() {
		return minuts;
	}



	public void setMinuts(String minuts) {
		this.minuts = minuts;
	}

	


	public String getStart() {
		return start;
	}



	public void setStart(String start) {
		this.start = start;
	}



	public String getEnd() {
		return end;
	}



	public void setEnd(String end) {
		this.end = end;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	



	public String getCurrencyCode() {
		return currencyCode;
	}



	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}



	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", reference=" + reference + ", lat=" + lat + ", longe=" + longe + ", date=" + date + ", month="
				+ month + ", day=" + day + ", hour=" + hour + ", minuts=" + minuts + ", seconds=" + seconds + ", start="
				+ start + ", end=" + end + ", price=" + price + ", currencyCode=" + currencyCode + ", user=" + user
				+ ", comments=" + comments + ", images=" + images + "]";
	}
	
	



	







}
