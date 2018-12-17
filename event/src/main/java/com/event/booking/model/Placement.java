package com.event.booking.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Placement")
public class Placement {
	
	private String table; // table number or name
	private String row;
	private String column;

}
