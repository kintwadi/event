package com.event.booking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="IMAGE")
public class Image  implements Serializable{
	
	private static final long serialVersionUID = -6125415645030376553L;
	@Id
	@GeneratedValue
	private long imageId;
	private String imageLink;

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="eventId")
	private Event event;
	
	public Image() {
		
	}
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imageLink=" + imageLink + ", event=" + event + "]";
	}
	
	
	
	
	
	
	
	
	

}
