package com.jtang.sounding.domain.config;

import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.units.Unit;
import com.jtang.sounding.values.utils.ValueFactory;
import com.jtang.sounding.values.utils.Values;

public class FieldConfigDefaults {
	
	public static FieldConfig temperature() {
		FieldConfig config = new FieldConfig(Field.TEMPERATURE);
		config.setLowerBound(Values.ABSOLUTE_ZERO);
		config.setNullable(true);
		config.setUnit(Unit.CELSIUS);
		return config;
	}
	
	public static FieldConfig dewpoint() {
		FieldConfig config = new FieldConfig(Field.DEWPOINT);
		config.setUpperBoundField(Field.TEMPERATURE);
		config.setLowerBound(Values.ABSOLUTE_ZERO);
		config.setNullable(true);
		config.setUnit(Unit.CELSIUS);
		return config;
	}

	public static FieldConfig pressure() {
		FieldConfig config = new FieldConfig(Field.PRESSURE);
		config.setLowerBound(ValueFactory.pressure_hPa(0));
		config.setNullable(false);
		config.setUnit(Unit.HECTOPASCAL);
		return config;
	}
	
	public static FieldConfig height() {
		FieldConfig config = new FieldConfig(Field.HEIGHT);
		config.setLowerBound(Values.SURFACE_HGT);
		config.setNullable(false);
		config.setUnit(Unit.METER);
		return config;
	}
	
	public static FieldConfig windSpeed() {
		FieldConfig config = new FieldConfig(Field.WIND_SPEED);
		config.setLowerBound(ValueFactory.speed_mps(0));
		config.setNullable(true);
		config.setUnit(Unit.METER_PER_SECOND);
		return config;
	}
	
	public static FieldConfig windDirection() {
		FieldConfig config = new FieldConfig(Field.WIND_DIRECTION);
		config.setNullable(true);
		config.setUnit(Unit.CARDINAL_DIRECTION);
		return config;
	}
	
	public static FieldConfig mixingRatio() {
		FieldConfig config = new FieldConfig(Field.MIXING_RATIO);
		config.setLowerBound(ValueFactory.mixingRatio_gpkg(0));
		config.setNullable(true);
		config.setUnit(Unit.GRAM_PER_KILOGRAM);
		return config;
	}
}
