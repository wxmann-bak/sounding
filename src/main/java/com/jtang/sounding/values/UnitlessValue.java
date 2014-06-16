package com.jtang.sounding.values;

import com.jtang.sounding.values.units.Unit;

public class UnitlessValue extends Value {
	
	public UnitlessValue(double value) {
		super(value, Unit.NULL);
	}

}
