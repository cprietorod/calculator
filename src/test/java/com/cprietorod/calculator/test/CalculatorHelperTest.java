package com.cprietorod.calculator.test;

import static org.junit.Assert.*;

import javax.script.ScriptException;

import org.junit.Test;

import com.cprietorod.calculator.helper.CalculatorHelper;
import com.cprietorod.calculator.helper.CalculatorHelperImp;

public class CalculatorHelperTest {

	@Test
	public void doCalculateTest() throws ScriptException {
		CalculatorHelper calculatorHelper = new CalculatorHelperImp(); 
		String result = calculatorHelper.doCalculate("2 + 2");
		assertEquals("4", result);
	}
	
	@Test
	public void validateOperationTest()  {
		CalculatorHelper calculatorHelper = new CalculatorHelperImp(); 
		assertTrue(calculatorHelper.validateOperation("2 +2"));
		assertFalse(calculatorHelper.validateOperation("asdf"));
	}

}
