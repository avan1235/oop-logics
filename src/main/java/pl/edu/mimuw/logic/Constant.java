package pl.edu.mimuw.logic;

import java.util.List;
import java.util.ArrayList;

public class Constant implements Formula {
	final private boolean value;
	
	public Constant(boolean value) {
		this.value = value;
	}
	
	public boolean eval(Valuation valuation) {
		return this.value;
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}
	
	public List<String> yieldVariables() {
		return new ArrayList<String>();
	}
}
