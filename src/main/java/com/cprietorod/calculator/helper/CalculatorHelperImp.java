package com.cprietorod.calculator.helper;

import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorHelperImp implements CalculatorHelper {

	@Override
	public String doCalculate(String operation) throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String foo = operation;
	    return "" +  engine.eval(foo);
	}

	@Override
	public boolean validateOperation(String operation) {
		Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
		return pattern.matcher(operation).find();
	}

}
