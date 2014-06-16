package com.jtang.sounding.values;

import com.jtang.sounding.utils.MathUtils;
import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.units.Unit;
import com.jtang.sounding.values.units.UnitConverter;

public class Value implements Comparable<Value> {

	double value;
	Unit unit;
	Dimension dimension;

	public Value(double value, Unit unit) {
		// try {
		this.value = value;
		// UnitChecker.checkUnitDimension(unit, dimension);
		this.unit = unit;
		this.dimension = unit.getDimension();
		// }
		// catch (UnitException ex) {
		// throw new ValueInstantiationException(ex);
		// }
	}

	public double getValue() {
		return value;
	}

	public Unit getUnit() {
		return unit;
	}

	public boolean isDimension(Dimension theDimension) {
		return dimension == theDimension;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public int hashCode() {
		return Double.valueOf(value).hashCode()
				+ unit.getRepresentation().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Value)) {
			return false;
		}
		Value otherValue = (Value) obj;
		if (otherValue.getDimension() != this.getDimension()) {
			return false;
		}
		if (otherValue.getUnit() != this.getUnit()) {
			return false;
		}
		return this.getValue() == otherValue.getValue();
	}

	public boolean equalsAfterConversion(Value otherValue) {
		if (otherValue.getDimension() != this.getDimension()) {
			return false;
		}
		Value convertedVal = otherValue;
		if (otherValue.getUnit() != this.getUnit()) {
			try {
				convertedVal = UnitConverter.convert(otherValue, getUnit());
			} catch (UnitException e) {
				// should not happen.
				e.printStackTrace();
				return false;
			}
		}
		return MathUtils.equalsApprox(this.getValue(), convertedVal.getValue());
	}

	/*
	 * (non-Javadoc) This compareTo checks units too.
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Value otherValue) {
		if (otherValue.getDimension() != this.getDimension()) {
			return 0;
		}
		if (this.equals(otherValue)) {
			return 0;
		}
		Value convertedVal = otherValue;
		if (otherValue.getUnit() != this.getUnit()) {
			try {
				convertedVal = UnitConverter.convert(otherValue, getUnit());
			} catch (UnitException e) {
				// should not happen.
				e.printStackTrace();
				return 0;
			}
		}
		if (MathUtils.equalsApprox(convertedVal.getValue(), this.getValue())) {
			return 0;
		}
		return convertedVal.getValue() > this.getValue() ? 1 : -1;
	}
}
