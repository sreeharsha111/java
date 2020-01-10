package com.spring.project.carparking.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CarparkingLocation {

	@Id
   
	private String location;
	private String area;
	private String phase;
	private String floor;
	 private long id;
	
	public CarparkingLocation() {
		super();
	}

	public CarparkingLocation(long id,String location,String area,String phase,String floor)
	{
		super();
	  
		this.location=location;
		this.area=area;
		this.phase=phase;
		this.floor=floor;
		  this.id=id;
	}



	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
