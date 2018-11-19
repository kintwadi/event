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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="eventId", nullable=false)
	private Event eventComment;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="userId", nullable=false)
	
	private User userComment;
	
	public Comment() {
		
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

	public Event getEventComment() {
		return eventComment;
	}

	public void setEventComment(Event eventComment) {
		this.eventComment = eventComment;
	}

	
	

	public User getUserComment() {
		return userComment;
	}

	public void setUserComment(User userComment) {
		this.userComment = userComment;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", calendarTimestamp=" + calendarTimestamp
				+ ", eventComment=" + eventComment + ", userComment=" + userComment + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}