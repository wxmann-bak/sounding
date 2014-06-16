package com.jtang.sounding.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jtang.sounding.domain.config.ObservationConfig;
import com.jtang.sounding.values.Dimension;
import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.Value;
import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.utils.UnitChecker;

public class Sounding {
	
	private Map<Value, Observation> observations;
	private ObservationConfig observationConfig;
	
	private Date date;
	private int hour;
	private String station;
	private Long stationId;
	
	public Sounding() {
		observations = new HashMap<Value, Observation>();
	}
	
	public void addObservation(Observation ob) {
		
		observations.put(ob.getFieldValue(Field.PRESSURE), ob);
	}

	public Observation getObservation(Value pressure) throws UnitException {
		
		UnitChecker.checkUnitDimension(pressure.getUnit(), Dimension.PRESSURE);
		return observations.get(pressure);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
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

	public ObservationConfig getObservationConfig() {
		return observationConfig;
	}

	public void setObservationConfig(ObservationConfig observationConfig) {
		this.observationConfig = observationConfig;
	}


}
