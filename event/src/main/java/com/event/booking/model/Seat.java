package com.event.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seat")
public class Seat {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String seatNumber;// chair number or name etc
	private String seatOwner; // the one who booked or joined the seat
	private String age; // adult, jung etc...
	private String group; // eg: smith couple
	private String meal; // beef, vegan or mix
	private String category; // Box, VIP, front seat etc...
	private String accessType; // for normal, pregnant,  fat or handicapped  person or woman/man with baby
	private String locked;//  yes = reserved or no = free
	
	
	

	
	
	
	

}
