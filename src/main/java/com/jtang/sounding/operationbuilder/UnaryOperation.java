package com.jtang.sounding.operationbuilder;

import java.util.ArrayList;
import java.util.List;

import com.jtang.sounding.operationbuilder.exception.IllegalNumberOfArgumentsException;

public class UnaryOperation implements Operation {
	
	public static Operation IDENTITY = new UnaryOperation() {
		
		public Operation inverse() {
			return this;
		}
		
		public Operation append(UnaryOperation operation) {
			return operation;
		}
		
		protected double doCalculation(double... inputs) {
			return inputs[0];
		}
	};
	
	List<OperatorOperandPair> operations;

	public UnaryOperation() {
		operations = new ArrayList<OperatorOperandPair>();
	}

	@Override
	public Operation inverse() {
		UnaryOperation inverse = new UnaryOperation();
        List<OperatorOperandPair> inverseList = new ArrayList<OperatorOperandPair>();    
        for (int i = operations.size()-1; i >= 0; i--) {
            inverseList.add(operations.get(i).inverseOperation());
        }
        inverse.operations = inverseList;
        return inverse;
	}

	@Override
	public Operation append(UnaryOperation operation) {
		UnaryOperation operationResult = new UnaryOperation();
    	List<OperatorOperandPair> finalOps = new ArrayList<OperatorOperandPair>();
    	finalOps.addAll(this.operations);
    	finalOps.addAll(operation.operations);
    	operationResult.operations = finalOps;
    	return operationResult;
	}
	
	protected double doCalculation(double... inputs) {
		double inputVal = inputs[0];
        for (OperatorOperandPair operation : operations) {
            inputVal = operation.getEvaluatedValue(inputVal);
        }
        return inputVal;
	}

	@Override
	public double evaluate(double... inputs) {
		if (inputs.length != expectedInputNumber()) {
			throw new IllegalNumberOfArgumentsException(String.format("Expected number of inputs to operation: %s != number of inputs: %s", expectedInputNumber(), inputs.length));
		}
		return doCalculation(inputs);
	}

	@Override
	public int expectedInputNumber() {
		return 1;
	}

	@Override
	public void addStep(Operator operator, double operand) {
		operations.add(new OperatorOperandPair(operator, operand));
	}
}
