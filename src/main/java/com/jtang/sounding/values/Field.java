package com.jtang.sounding.values;

import com.jtang.sounding.values.exception.FieldException;

public enum Field {
	
	PRESSURE(Dimension.PRESSURE, "PRESSURE"),
	HEIGHT(Dimension.HEIGHT, "HEIGHT"),
	TEMPERATURE(Dimension.TEMPERATURE, "TEMPERATURE"),
	DEWPOINT(Dimension.TEMPERATURE, "DEWPOINT"),
	WIND_SPEED(Dimension.SPEED, "WIND_SPEED"),
	WIND_DIRECTION(Dimension.ANGLE, "WIND_DIR"),
	MIXING_RATIO(Dimension.MIXING_RATIO, "MIXING_RATIO"),
	POTENTIAL_TEMPERATURE(Dimension.TEMPERATURE, "POTENTIAL_TEMP");
	
	Dimension dimension;
	String representation;
	
	private Field(Dimension dimension, String representation) {
		this.dimension = dimension;
	}
	
	public Dimension getDimension() {
		return dimension;
	}
	
	public String getRepresentation() {
		return representation;
	}
	
	public static Field getField(String representation) throws FieldException {
		
		for (Field field : Field.values()) {
			if (field.getRepresentation().equalsIgnoreCase(representation)) {
				return field;
			}
		}
		throw new FieldException("Cannot find field: " + representation);
	}
}
