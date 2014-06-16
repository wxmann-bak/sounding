package com.jtang.sounding.values.units;

import java.util.HashMap;
import java.util.Map;

import com.jtang.sounding.operationbuilder.Operation;
import com.jtang.sounding.operationbuilder.Operator;
import com.jtang.sounding.operationbuilder.UnaryOperation;
import com.jtang.sounding.values.exception.InvalidSIPrefixException;

public class UnitConversionLibrary {
	
	private static final Map<String, Integer> SI_PREFIX_MAPPING;
	static {
		SI_PREFIX_MAPPING = new HashMap<String, Integer>();
		SI_PREFIX_MAPPING.put("G", 9);
		SI_PREFIX_MAPPING.put("M", 6);
		SI_PREFIX_MAPPING.put("k", 3);
		SI_PREFIX_MAPPING.put("h", 2);
		SI_PREFIX_MAPPING.put("da", 1);
		SI_PREFIX_MAPPING.put("d", -1);
		SI_PREFIX_MAPPING.put("c", -2);
		SI_PREFIX_MAPPING.put("m", -3);
		SI_PREFIX_MAPPING.put("µ", -6);
		SI_PREFIX_MAPPING.put("n", -9);
	}
	
	public static Operation IDENTITY = UnaryOperation.IDENTITY;

	private UnitConversionLibrary() {
	}
	
	public static Operation getPrefixOperation(String unitStr, String base) {
		if (unitStr.endsWith(base)) {
			Integer pow = SI_PREFIX_MAPPING.get(unitStr.replace(base, ""));
			if (pow == null) {
				throw new InvalidSIPrefixException("Invalid SI prefix for unit: " + unitStr);
			} else {
				Operation theOp = new UnaryOperation();
				theOp.addStep(Operator.MULTIPLY, Math.pow(10, pow));
				return theOp;
			}
		}
		throw new InvalidSIPrefixException(String.format("Cannot find prefix for unit: %s, base unit: %s", unitStr, base));
	}
	
	public static class Temperature {
		
		private static double C_TO_K_TERM = 273.15;
		
		public static Operation CELSIUS_TO_KELVIN = celsiusToKelvin();
		public static Operation FAHRENHEIT_TO_KELVIN = fahrenheitToKelvin();
		
		private static Operation celsiusToKelvin() {
			Operation theOperation = new UnaryOperation();
			theOperation.addStep(Operator.ADD, C_TO_K_TERM);
			return theOperation;
		}
		
		private static Operation fahrenheitToKelvin() {
			Operation theOperation = new UnaryOperation();
			theOperation.addStep(Operator.SUBTRACT, 32);
			theOperation.addStep(Operator.MULTIPLY, 5.0/9.0);
			theOperation.addStep(Operator.ADD, C_TO_K_TERM);
			return theOperation;
		}
	}
	
	public static class Speed {
		
		private static double KT_TO_MPS_FACTOR = 0.514444;
		private static double MPH_TO_MPS_FACTOR = 0.44704;
		
		public static Operation KNOTS_TO_METERS_PER_SECOND = knotToMps();
		public static Operation MILES_PER_HOUR_TO_METERS_PER_SECOND = mphToMps();
		
		private static Operation knotToMps() {
			Operation theOperation = new UnaryOperation();
			theOperation.addStep(Operator.MULTIPLY, KT_TO_MPS_FACTOR);
			return theOperation;
		}
		
		private static Operation mphToMps() {
			Operation theOperation = new UnaryOperation();
			theOperation.addStep(Operator.MULTIPLY, MPH_TO_MPS_FACTOR);
			return theOperation;
		}
	}
	
	public static class Angle {
		
		public static Operation RADIANS_TO_DEGREES = radToDeg();
		public static Operation CARDINAL_DIRECTION_TO_DEGREES = carDirToDeg();
		
		private static Operation radToDeg() {
			Operation theOperation = new UnaryOperation();
			theOperation.addStep(Operator.MULTIPLY, 180);
			theOperation.addStep(Operator.DIVIDE, Math.PI);
			return theOperation;
		}
		
		private static Operation carDirToDeg() {
			Operation theOperation = new UnaryOperation();
			theOperation.addStep(Operator.SUBTRACT, 90);
			theOperation.addStep(Operator.ADD, 360);
			return theOperation;
		}
	}

}
