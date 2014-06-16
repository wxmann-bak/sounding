package com.jtang.sounding.values;

public class VectorValue {
	
	private Value magnitude;
	private Value angle;

	public VectorValue(Value magnitude, Value angle) {
		this.angle = angle;
		this.magnitude = magnitude;
	}

	public Value getMagnitude() {
		return magnitude;
	}

	public Value getAngle() {
		return angle;
	}

}
