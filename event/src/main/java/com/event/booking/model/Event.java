package com.event.booking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Event extends EventDetails implements Serializable {
	
	private static final long serialVersionUID = 9050990180781303058L;
	
	@Column(nullable = false) 
	private String type;
	private String description;
	
	public Event() {
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescriptionn(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Event [type=" + type + ", description=" + description + "]";
	}
	
	
	
	
	
	

}
