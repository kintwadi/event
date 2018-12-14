package com.event.booking.model;

import java.io.Serializable;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar calendarTimestamp;
	
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

	public java.util.Calendar getCalendarTimestamp() {
		return calendarTimestamp;
	}

	public void setCalendarTimestamp(java.util.Calendar calendarTimestamp) {
		this.calendarTimestamp = calendarTimestamp;
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

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", calendarTimestamp=" + calendarTimestamp
				+ ", event=" + event + ", user=" + user + "]";
	}
	
	
	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
}