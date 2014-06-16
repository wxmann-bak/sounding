package com.jtang.sounding.operationbuilder;

import org.junit.Assert;
import org.junit.Test;

import com.jtang.sounding.utils.MathUtils;

public class UnaryOperationTest {
	
	@Test
	public void testIdentityOperation() {
		double input = 2.22;
		
		Assert.assertTrue(UnaryOperation.IDENTITY.evaluate(input) == input);
		Assert.assertTrue(UnaryOperation.IDENTITY.inverse().evaluate(input) == input);
	}
	
	@Test
	public void testAppendEvaluate() {
		double input = 2.2;
		
		Operation op1 = new UnaryOperation();
		double op1Add = 5;
		op1.addStep(Operator.ADD, op1Add);
		Operation op2 = new UnaryOperation();
		op2.addStep(Operator.SUBTRACT, op1Add);
		op2.addStep(Operator.SUBTRACT, input);
		
		Operation finalOp = op1.append((UnaryOperation)op2);

		Assert.assertTrue(finalOp.evaluate(input) == 0);
	}

	@Test
	public void testInverseEvaluate() {
		Operation op1 = new UnaryOperation();
		double add = 1;
		double multiply = 2;
		double divide1 = 3;
		double divide2 = 4;
		op1.addStep(Operator.ADD, add);
		op1.addStep(Operator.MULTIPLY, multiply);
		op1.addStep(Operator.DIVIDE, divide1);
		op1.addStep(Operator.DIVIDE, divide2);
		
		Operation op2 = op1.inverse();
		double input = 3;
		Assert.assertTrue(MathUtils.equalsApprox(op2.evaluate(op1.evaluate(input)), input));
	}

}
