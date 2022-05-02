package pl.edu.mimuw.logic;

import java.util.List;
import java.util.ArrayList;

public class And implements Formula {
	final private Formula left, right;
	
	public And(Formula left, Formula right) {
		this.left = left;
		this.right = right;
	}
	
	public boolean eval(Valuation valuation) {
		return this.left.eval(valuation) & this.right.eval(valuation);
	}
	
	public String toString() {
		String result = "";
		
		if(this.left instanceof Constant || this.left instanceof Variable) {
			result += this.left.toString();
		}
		else {
			result += "(" + this.left.toString() + ")";
		}
		
		result += " and ";
		
		if(this.right instanceof Constant || this.right instanceof Variable) {
			result += this.right.toString();
		}
		else {
			result += "(" + this.right.toString() + ")";
		}
		
		return result;
	}
	
	public List<String> yieldVariables() {
		final List<String> leftVariables = this.left.yieldVariables(),
		             rightVariables = this.right.yieldVariables();
		
		List<String> result = new ArrayList<String>();
		int i = 0;
		for(String x: leftVariables) {
			while(i < rightVariables.size() && x.compareTo(rightVariables.get(i)) >= 0) {
				if(!x.equals(rightVariables.get(i))) {
					result.add(new String(rightVariables.get(i)));
				}
				i++;
			}
			result.add(new String(x));
		}
		while(i < rightVariables.size()) {
			result.add(new String(rightVariables.get(i)));
			i++;
		}
		
		return result;
	}
}
