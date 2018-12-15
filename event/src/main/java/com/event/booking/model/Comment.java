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
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="COMMENT")
public class Comment  implements Serializable{
	

	private static final long serialVersionUID = -5004223313784109665L;
	@Id
	@GeneratedValue
	private long commentId;
	private String comment;
	
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
	
	public Comment() {
		
	}
	
	public Comment addRelationShip(Object object) {
		
		if(object instanceof User) {
			this.user = (User)object;
			return this;
		}
		
		this.event = (Event)object;
		return this;
			
	}

	public long getId() {
		return commentId;
	}

	public void setId(long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
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

	public Event getEvent() {
		return event;
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

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", date=" + date + ", month=" + month
				+ ", day=" + day + ", hour=" + hour + ", minuts=" + minuts + ", seconds=" + seconds + ", event=" + event
				+ ", user=" + user + "]";
	}

	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
}