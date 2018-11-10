package com.event.booking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Event extends EventDetails implements Serializable {
	
	private static final long serialVersionUID = 9050990180781303058L;
	
	@Column(nullable = false) 
	private String type;
	private String secription;
	
	public Event() {
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSecription() {
		return secription;
	}
	public void setSecription(String secription) {
		this.secription = secription;
	}
	@Override
	public String toString() {
		return "Event [type=" + type + ", secription=" + secription + "]";
	}
	
	
	
	
	
	

}
