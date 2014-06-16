package com.jtang.sounding.values.utils;

import com.jtang.sounding.values.Dimension;
import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.exception.DimensionException;
import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.units.Unit;

public class UnitChecker {

	private UnitChecker() {
	}

	public static void checkFieldDimension(Field field1, Field field2) throws DimensionException {

		if (field1.getDimension() != field2.getDimension()) {
			throw new DimensionException(String.format(
					"Dimension %s for field: %s != dimension %s supplied in field: %s", field1.getDimension(), field1,
					field2.getDimension(), field2));
		}
	}

	public static void checkSameUnit(Unit unit1, Unit unit2) throws UnitException {
		if (unit1 != unit2) {
			throw new UnitException(String.format("Unit: %s does not match unit: %s", unit1.getRepresentation(),
					unit2.getRepresentation()));
		}
	}

	public static void checkDimensionless(Unit unit) throws UnitException {
		if (unit.getDimension() != null && unit.getDimension() != Dimension.NULL) {
			throw new UnitException(String.format("Unit: %s is not dimensionless", unit.getRepresentation()));
		}
	}

	public static void checkUnitDimension(Unit unit, Dimension expected) throws UnitException {
		if (unit == null && expected == Dimension.NULL) {
			// that's okay
		}
		else if (unit.getDimension() != expected) {
			throw new UnitException(String.format("Unit: %s not expected for dimension: %s", unit.getRepresentation(),
					expected));
		}
	}

	public static void checkSameDimension(Unit unit1, Unit unit2) throws UnitException {
		if (!unit1.isSameDimension(unit2)) {
			throw new UnitException(String.format("Unit: %s does not match dimension of unit: %s",
					unit1.getRepresentation(), unit2.getRepresentation()));
		}
	}
}
