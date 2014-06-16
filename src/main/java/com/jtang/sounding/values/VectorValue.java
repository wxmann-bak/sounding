package com.jtang.sounding.values;

public class VectorValue<T extends Value> {
	
	private T magnitude;
	private Value angle;

	public VectorValue(T magnitude, Value angle) {
		this.angle = angle;
		this.magnitude = magnitude;
	}

	public T getMagnitude() {
		return magnitude;
	}

	public Value getAngle() {
		return angle;
	}

}
