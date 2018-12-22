package com.event.booking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="JOINEVENT")
public class JoinEvent implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long joinEventId;
	
	private boolean paid;
	private int bookingCountDays;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private String month;
	private String day;
	private String hour;
	private String minuts;
	private String seconds;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="eventId")
	private Event event;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	
	private long plecement;

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

	public long getJoinEventId() {
		return joinEventId;
	}

	public void setJoinEventId(long joinEventId) {
		this.joinEventId = joinEventId;
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
	
	public long getPlecement() {
		return plecement;
	}
	public void setPlecement(long plecement) {
		this.plecement = plecement;
	}
	@Override
	public String toString() {
		return "JoinEvent [joinEventId=" + joinEventId + ", paid=" + paid + ", bookingCountDays=" + bookingCountDays
				+ ", date=" + date + ", month=" + month + ", day=" + day + ", hour=" + hour + ", minuts=" + minuts
				+ ", seconds=" + seconds + ", event=" + event + ", user=" + user + "]";
	}



}
