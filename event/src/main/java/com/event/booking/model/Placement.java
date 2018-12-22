package com.event.booking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PLACEMENT")
public class Placement  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long placementId;
	private String desk;
	private String x;
	private String y;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="seatId")
	private Seat seat;
	
	/*@JsonIgnore
	@OneToMany(mappedBy ="placement", fetch=FetchType.EAGER, cascade=CascadeType.ALL)      
	@Fetch(value = FetchMode.SUBSELECT)                                               
	private List<JoinEvent>joinEvents = new ArrayList<>(); */
	
	
	public Placement() {
		
	}
	public long getPlacementId() {
		return placementId;
	}
	
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public String getDesk() {
		return desk;
	}
	public void setDesk(String desk) {
		this.desk = desk;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public void setPlacementId(long placementId) {
		this.placementId = placementId;
	}
	/*public List<JoinEvent> getJoinEvents() {
		return joinEvents;
	}
	public void setJoinEvents(List<JoinEvent> joinEvents) {
		this.joinEvents = joinEvents;
	}*/
	
	
	
	
	
	
	

}
