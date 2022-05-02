package pl.edu.mimuw.logic;

import java.util.List;
import java.util.ArrayList;

public class Neg implements Formula {
	final private Formula formula;
	
	public Neg(Formula formula) {
		this.formula = formula;
	}
	
	public boolean eval(Valuation valuation) {
		return !this.formula.eval(valuation);
	}
	
	public String toString() {
		String result = "not ";
		
		if(this.formula instanceof Constant || this.formula instanceof Variable) {
			result += this.formula.toString();
		}
		else {
			result += "(" + this.formula.toString() + ")";
		}
		
		return result;
	}
	
	public List<String> yieldVariables() {
		return new ArrayList<String>(this.formula.yieldVariables());
	}
}
