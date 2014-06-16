package com.jtang.sounding.operationbuilder;

public class OperatorOperandPair {

	private Operator operator;
    private double operand;
    
    public OperatorOperandPair(Operator operator, double secondOperand) {
        this.operator = operator;
        this.operand = secondOperand;
    }
    
    public double getEvaluatedValue(double arg) {
        
        return operator.doOperation(arg, operand);
    }
    
    public OperatorOperandPair inverseOperation() {
        
        return new OperatorOperandPair(operator.inverse(), operand);
    }

}
