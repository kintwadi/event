package com.event.booking.model;

import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy="eventImage")
	private List<Image >image;

	@ManyToOne
    @JoinColumn(name="commentId", nullable=false)
	private Comment eventComment;
	
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

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

	public Comment getEventComment() {
		return eventComment;
	}

	public void setEventComment(Comment eventComment) {
		this.eventComment = eventComment;
	}

	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", reference=" + reference + ", lat=" + lat + ", longe=" + longe + ", image=" + image
				+ ", eventComment=" + eventComment + "]";
	}
	

}
