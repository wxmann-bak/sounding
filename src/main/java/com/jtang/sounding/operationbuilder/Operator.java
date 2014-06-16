package com.jtang.sounding.operationbuilder;

public enum Operator {

	ADD, MULTIPLY, DIVIDE, SUBTRACT;

	public Operator inverse() {
		switch (this) {
		case ADD:
			return SUBTRACT;
		case SUBTRACT:
			return ADD;
		case MULTIPLY:
			return DIVIDE;
		case DIVIDE:
			return MULTIPLY;
			// case EXPONENTIATE: return Math.pow(arg1, arg2);
		}
		throw new IllegalArgumentException("Invalid operator");
	}

	public double doOperation(double arg1, double arg2) {

		switch (this) {
		case ADD:
			return arg1 + arg2;
		case SUBTRACT:
			return arg1 - arg2;
		case MULTIPLY:
			return arg1 * arg2;
		case DIVIDE:
			return arg1 / arg2;
			// case EXPONENTIATE: return Math.pow(arg1, arg2);
		}
		throw new IllegalArgumentException("Invalid operator");
	}

}
