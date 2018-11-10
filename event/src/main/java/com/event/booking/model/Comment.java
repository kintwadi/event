package com.event.booking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
    @JoinColumn(name="userId", nullable=false)
	private User userComment;

	@OneToMany(mappedBy="eventComment")
	private List<Event >event;
	
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

	public User getUserComment() {
		return userComment;
	}

	public void setUserComment(User userComment) {
		this.userComment = userComment;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", calendarTimestamp=" + calendarTimestamp
				+ ", userComment=" + userComment + ", event=" + event + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}