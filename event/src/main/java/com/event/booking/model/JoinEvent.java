package com.event.booking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="JOINEVENT")
public class JoinEvent implements Serializable {


	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JoinEventHelper id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="eventId")
	@MapsId("eventId")
	private Event event;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="userId")
	@MapsId("userId")
	private User user;
	

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="placementId")
	@MapsId("placementId")
	private Placement plecement;
	

	private boolean paid;
	private int bookingCountDays;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private String month;
	private String day;
	private String hour;
	private String minuts;
	private String seconds;

	public JoinEvent(){

	}
	public JoinEvent addRelationShip(Object object) {

		if(object instanceof User) {
			this.user = (User)object;
			return this;
		}
		

		this.event = (Event)object;
		return this;

	}

	


	public JoinEventHelper getId() {
		return id;
	}
	public void setId(JoinEventHelper id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getSeconds() {
		return seconds;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public int getBookingCountDays() {
		return bookingCountDays;
	}
	public void setBookingCountDays(int bookingCountDays) {
		this.bookingCountDays = bookingCountDays;
	}
	
	
	public Placement getPlecement() {
		return plecement;
	}
	public void setPlecement(Placement plecement) {
		this.plecement = plecement;
	}
	



}
