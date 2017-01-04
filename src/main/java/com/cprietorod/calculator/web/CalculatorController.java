package com.cprietorod.calculator.web;

import java.io.IOException;

import javax.script.ScriptException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cprietorod.calculator.helper.CalculatorHelper;
import com.cprietorod.calculator.helper.CalculatorHelperImp;

@WebServlet("/rest")
public class CalculatorController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	CalculatorHelper calculatorHelper= new CalculatorHelperImp(); 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
		String operation = request.getParameter("operation");
		response.setContentType("application/json");
		if (calculatorHelper.validateOperation(operation)){
			try {
				String result = calculatorHelper.doCalculate(operation);
				response.getWriter().println("{\"success\":true, \"result\":\""+result+"\"}");
			} catch (ScriptException e) {
				response.getWriter().println("{'success':false}");
			}
			
		}else{
			response.getWriter().println("{'success':false}");
		}
    }

}
