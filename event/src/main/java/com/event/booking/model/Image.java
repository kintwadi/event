package com.event.booking.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="IMAGE")
public class Image  implements Serializable{
	
	private static final long serialVersionUID = -6125415645030376553L;
	@Id
	@GeneratedValue
	private long id;
	private String imageLink;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="eventId", nullable=false)
	private Event eventImage;
	
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
	@Override
	public String toString() {
		return "Image [id=" + id + ", imageLink=" + imageLink + ", eventImage=" + eventImage + "]";
	}
	
	
	
	
	
	
	

}
