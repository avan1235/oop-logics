package pl.edu.mimuw.logic;

import java.util.Map;
import java.util.HashMap;

public class Valuation {
	private Map<String, Boolean> valuesOfVariables;
	
	public Valuation() {
		this.valuesOfVariables = new HashMap<String, Boolean>();
	}
	
	public void addVariable(String name, boolean value) {
		if(name == "true" || name == "false") {
			throw new IllegalArgumentException("Seriously?");
		}
		
		this.valuesOfVariables.put(name, value);
	}
	
	public void removeVariable(String name) {
		this.valuesOfVariables.remove(name);
	}
	
	public boolean getValue(String name) {
		if(!this.valuesOfVariables.containsKey(name)) {
			return false;
		}
		
		return this.valuesOfVariables.get(name);
	}
}
