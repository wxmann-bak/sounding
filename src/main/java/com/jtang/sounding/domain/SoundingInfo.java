package com.jtang.sounding.domain;

import java.util.Date;

public class SoundingInfo {
	
	private Integer hour;
	private Date date;
	private String station;
	private Long stationId;
	private Boolean modified;
	
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public Long getStationId() {
		return stationId;
	}
	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}
	public Boolean isModified() {
		return modified;
	}
	public void setModified(Boolean modified) {
		this.modified = modified;
	}

}
