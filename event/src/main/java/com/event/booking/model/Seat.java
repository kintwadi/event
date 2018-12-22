package com.event.booking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SEAT")
public class Seat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long seatId;
	
	private String reference;// seat number or name etc
	private String seatOwner; // the one who booked or joined the seat
	private String age; // adult, jung etc...
	private String meal; // beef, vegan or mix
	private String category; // Box, VIP, front seat etc...
	private String accessType; // for normal, pregnant, group, fat or handicapped  person or woman/man with baby
	private String reserved;//  yes = reserved or no = free
	
	@JsonIgnore
	@OneToMany(mappedBy ="seat", fetch=FetchType.EAGER, cascade=CascadeType.ALL)      
	@Fetch(value = FetchMode.SUBSELECT)                                               
	private List<Placement>placements = new ArrayList<>();
	
	
	public Seat() {
		
	}
	
	

	public long getSeatId() {
		return seatId;
	}



	public void setSeatId(long chairId) {
		this.seatId = chairId;
	}



	public List<Placement> getPlacements() {
		return placements;
	}

	public void setPlacements(List<Placement> placements) {
		this.placements = placements;
	}



	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}



	public String getSeatOwner() {
		return seatOwner;
	}



	public void setSeatOwner(String seatOwner) {
		this.seatOwner = seatOwner;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}


	public String getMeal() {
		return meal;
	}



	public void setMeal(String meal) {
		this.meal = meal;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getAccessType() {
		return accessType;
	}



	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}



	public String getReserved() {
		return reserved;
	}



	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	
	
	

	
	
	
	

	

}
