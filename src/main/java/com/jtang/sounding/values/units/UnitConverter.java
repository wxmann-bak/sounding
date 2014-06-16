package com.jtang.sounding.values.units;

import com.jtang.sounding.operationbuilder.Operation;
import com.jtang.sounding.operationbuilder.UnaryOperation;
import com.jtang.sounding.values.Value;
import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.utils.UnitChecker;

public class UnitConverter {

	private UnitConverter() {
	}

	public static Value convert(Value value, Unit unitConvertTo) throws UnitException {
		UnitChecker.checkUnitDimension(unitConvertTo, value.getDimension());
		if (value.getUnit() == unitConvertTo) {
			return value;
		}
		Operation convertToBaseUnit = value.getUnit().getToBaseUnitOperation();
		Operation convertFromBaseUnit = unitConvertTo.getToBaseUnitOperation().inverse();
		Operation finalOperation = convertToBaseUnit.append((UnaryOperation) convertFromBaseUnit);

		double finalValue = finalOperation.evaluate(value.getValue());
		return new Value(finalValue, unitConvertTo);
	}

}
