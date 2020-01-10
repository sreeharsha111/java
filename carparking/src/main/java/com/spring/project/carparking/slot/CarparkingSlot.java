package com.spring.project.carparking.slot;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.spring.project.carparking.location.CarparkingLocation;

@Entity
public class CarparkingSlot {

	@Id
	private long id;
	private String branch;
	private String phase;
	private long floor;

	private long totalslots;
	private long availableslots;
	public CarparkingSlot() {
		super();
	}
	public CarparkingSlot(long id,String branch,String phase,long floor,long totalslots,long availableslots)
	{
		super();
		this.id=id;
		this.branch=branch;
		this.phase=phase;
		this.floor=floor;
		this.totalslots=totalslots;
		this.availableslots=availableslots;
	
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public long getFloor() {
		return floor;
	}
	public void setFloor(long floor) {
		this.floor = floor;
	}
	public long getTotalslots() {
		return totalslots;
	}
	public void setTotalslots(long totalslots) {
		this.totalslots = totalslots;
	}
	public long getAvailableslots() {
		return availableslots;
	}
	public void setAvailableslots(long availableslots) {
		this.availableslots = availableslots;
	}
	
	}
