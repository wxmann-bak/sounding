package com.jtang.sounding.operationbuilder;

public interface Operation {

	Operation inverse();
	
	Operation append(UnaryOperation operation);
	
	double evaluate(double... input);
	
	int expectedInputNumber();
	
	void addStep(Operator operator, double operand);
}
