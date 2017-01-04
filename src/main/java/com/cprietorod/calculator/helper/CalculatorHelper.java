package com.cprietorod.calculator.helper;

import javax.script.ScriptException;

public interface CalculatorHelper {
	String doCalculate(String operation) throws ScriptException;

	boolean validateOperation(String operation);

}
