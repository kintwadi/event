package com.event.booking.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="IMAGE")
public class Image  implements Serializable{
	
	private static final long serialVersionUID = -6125415645030376553L;
	@Id
	@GeneratedValue
	private long id;
	private String imageLink;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	
	public Image() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return "Image [id=" + id + ", imageLink=" + imageLink + ", event=" + event + "]";
	}
	
	
	
	
	
	
	

}
