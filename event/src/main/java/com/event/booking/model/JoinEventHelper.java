package com.event.booking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JoinEventHelper  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Column(name = "eventId")
	private long eventId;
	@Column(name = "userId")
	private long userId;
	@Column(name = "placementId")
	private long placementId;
	
	
	
	public JoinEventHelper() {
		super();
	}
	
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPlacementId() {
		return placementId;
	}
	public void setPlacementId(long placementId) {
		this.placementId = placementId;
	}
	
	
	

}
