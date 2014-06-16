package com.jtang.sounding.domain.config;

import com.jtang.sounding.values.Dimension;
import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.Value;
import com.jtang.sounding.values.units.Unit;

public class FieldConfig {
	
	private Field field;
	private Dimension dimension;
	private Unit unit;
	private Value lowerBound;
	private Field lowerBoundField;
	private Value upperBound;
	private Field upperBoundField;
	private boolean nullable;

	public FieldConfig(Field field) {
		if (field == null) {
			throw new NullPointerException();
		}
		this.field = field;
		this.dimension = field.getDimension();
		nullable = true;
	}
	
//	public boolean validate(Value value, Value valueForLinkedField) {
//		if (validate(value)) {
//			if (valueForLinkedField == null && value != null) {
//				return false;
//			}
//			boolean isValid = true;
//			if (hasLowerBoundField() && value.compareTo(valueForLinkedField) < 0) {
//				isValid = false;
//			}
//			if (hasUpperBoundField() && value.compareTo(valueForLinkedField) > 0) {
//				isValid = false;
//			}
//			return isValid;
//		}
//		return false;
//	}
//	
//	public boolean validate(Value value) {
//		if (value == null) {
//			return nullable;
//		}
//		if (field.getDimension() == value.getDimension()) {		
//			boolean isValid = true;
//			if (value.getUnit() != unit) {
//				isValid = false;
//			}
//			if (hasLowerBound() && value.compareTo(lowerBound) < 0) {
//				isValid = false;
//			}
//			if (hasUpperBound() && value.compareTo(upperBound) > 0) {
//				isValid = false;
//			}
//			return isValid;
//		}
//		return false;
//	}
	
	public Field getField() {
		return field;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public boolean hasLowerBound() {
		return lowerBound != null;
	}

	public Value getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Value lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	public boolean hasUpperBound() {
		return upperBound != null;
	}

	public Value getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Value upperBound) {
		this.upperBound = upperBound;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	
	public boolean hasLowerBoundField() {
		return lowerBoundField != null;
	}

	public Field getLowerBoundField() {
		return lowerBoundField;
	}

	public void setLowerBoundField(Field lowerBoundField) {
		this.lowerBoundField = lowerBoundField;
	}
	
	public boolean hasUpperBoundField() {
		return upperBoundField != null;
	}

	public Field getUpperBoundField() {
		return upperBoundField;
	}

	public void setUpperBoundField(Field upperBoundField) {
		this.upperBoundField = upperBoundField;
	}

}
