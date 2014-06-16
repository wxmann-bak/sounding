package com.jtang.sounding.values.units;

import com.jtang.sounding.operationbuilder.Operation;
import com.jtang.sounding.values.Dimension;
import com.jtang.sounding.values.exception.UnitException;

public enum Unit {
	
	NULL("", Dimension.NULL),
	
	KELVIN("K", Dimension.TEMPERATURE),
	CELSIUS("C", Dimension.TEMPERATURE, UnitConversionLibrary.Temperature.CELSIUS_TO_KELVIN),
	FAHRENHEIT("F", Dimension.TEMPERATURE, UnitConversionLibrary.Temperature.FAHRENHEIT_TO_KELVIN),
	
	METER("m", Dimension.HEIGHT),
	KILOMETER("km", Dimension.HEIGHT, UnitConversionLibrary.getPrefixOperation("km", METER.getRepresentation())),
	DECAMETER("dam", Dimension.HEIGHT, UnitConversionLibrary.getPrefixOperation("dam", METER.getRepresentation())),
	
	PASCAL("Pa", Dimension.PRESSURE),
	// Note: mb == hPa
	MILLIBAR("mb", Dimension.PRESSURE, UnitConversionLibrary.getPrefixOperation("hPa", PASCAL.getRepresentation())),
	HECTOPASCAL("hPa", Dimension.PRESSURE, UnitConversionLibrary.getPrefixOperation("hPa", PASCAL.getRepresentation())),
	KILOPASCAL("kPa", Dimension.PRESSURE, UnitConversionLibrary.getPrefixOperation("kPa", PASCAL.getRepresentation())),
	
	METER_PER_SECOND("m/s", Dimension.SPEED),
	KNOT("kt", Dimension.SPEED, UnitConversionLibrary.Speed.KNOTS_TO_METERS_PER_SECOND),
	MILE_PER_HOUR("mph", Dimension.SPEED, UnitConversionLibrary.Speed.MILES_PER_HOUR_TO_METERS_PER_SECOND),
	
	DEGREES("deg", Dimension.ANGLE),
	CARDINAL_DIRECTION("deg*", Dimension.ANGLE, UnitConversionLibrary.Angle.CARDINAL_DIRECTION_TO_DEGREES),
	RADIANS("rad", Dimension.ANGLE, UnitConversionLibrary.Angle.RADIANS_TO_DEGREES),
	
	GRAM_PER_KILOGRAM("g/kg", Dimension.MIXING_RATIO, UnitConversionLibrary.IDENTITY),
	KILOGRAM_PER_KILOGRAM("kg/kg", Dimension.MIXING_RATIO, UnitConversionLibrary.getPrefixOperation("kg/kg", GRAM_PER_KILOGRAM.getRepresentation()));
	
	private final String representation;
	private final Dimension dimension;
	private final Operation toBaseUnitOperation;
	
	Unit(String representation, Dimension dimension) {
		this(representation, dimension, UnitConversionLibrary.IDENTITY);
	}
	
	Unit(String representation, Dimension dimension, Operation toBaseUnitOperation) {
		this.representation = representation;
		this.dimension = dimension;
		this.toBaseUnitOperation = toBaseUnitOperation;
	}

	public String getRepresentation() {
		return representation;
	}

	public Dimension getDimension() {
		return dimension;
	}
	
	public boolean isSameDimension(Unit otherUnit) {
		return this.dimension == otherUnit.dimension;
	}
	
	public Operation getToBaseUnitOperation() {
		return toBaseUnitOperation;
	}
	
	public static Unit getUnit(String unitStr) throws UnitException {
		for (Unit unit : Unit.values()) {
			if (unitStr.equals(unit.getRepresentation())) {
				return unit;
			}
		}
		throw new UnitException("Unit not found: " + unitStr);
	}

}
