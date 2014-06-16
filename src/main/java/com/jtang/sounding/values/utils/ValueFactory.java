package com.jtang.sounding.values.utils;

import com.jtang.sounding.values.UnitlessValue;
import com.jtang.sounding.values.Value;
import com.jtang.sounding.values.units.Unit;

public class ValueFactory {
	
	public static Value number(double num) {
		return new UnitlessValue(num);
	}
	
	public static Value height_m(double hgt) {
		return new Value(hgt, Unit.METER);
	}
	
	public static Value pressure_hPa(double pres) {
		return new Value(pres, Unit.HECTOPASCAL);
	}
	
	public static Value temperature_K(double temp) {
		return new Value(temp, Unit.KELVIN);
	}
	
	public static Value temperature_C(double temp) {
		return new Value(temp, Unit.CELSIUS);
	}
	
	public static Value temperature_F(double temp) {
		return new Value(temp, Unit.FAHRENHEIT);
	}
	
	public static Value angle_deg(double ang) {
		return new Value(ang, Unit.DEGREES);
	}
	
	public static Value speed_mps(double speed) {
		return new Value(speed, Unit.METER_PER_SECOND);
	}
	
	public static Value mixingRatio_gpkg(double mr) {
		return new Value(mr, Unit.GRAM_PER_KILOGRAM);
	}

}
