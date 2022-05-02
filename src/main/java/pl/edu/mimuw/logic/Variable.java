package pl.edu.mimuw.logic;

import java.util.List;
import java.util.ArrayList;

public class Variable implements Formula {
	final private String name;
	
	public Variable(String name) {
		if(name == "true" || name == "false") {
			throw new IllegalArgumentException("Seriously?");
		}
		
		this.name = name;
	}
	
	public boolean eval(Valuation valuation) {
		return valuation.getValue(this.name);
	}
	
	public String toString() {
		return this.name;
	}
	
	public List<String> yieldVariables() {
		List<String> result = new ArrayList<String>();
		result.add(this.name);
		
		return result;
	}
}
