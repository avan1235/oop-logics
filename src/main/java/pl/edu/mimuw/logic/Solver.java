package pl.edu.mimuw.logic;

import java.util.List;
import java.util.ArrayList;

public class Solver {
	private Solver() {}
	
	public static Valuation solve(Formula formula) {
		final List<String> variables = formula.yieldVariables();
		final int n = variables.size();
		
		for(int bitmask = 0; bitmask < (1 << n); bitmask++) {
			Valuation maybe = new Valuation();
			for(int bit = 0; bit < n; bit++) {
				if(((bitmask >> bit) & 1) == 1) {
					maybe.addVariable(variables.get(bit), true);
				}
				else {
					maybe.addVariable(variables.get(bit), false);
				}
			}
			
			if(formula.eval(maybe)) {
				return maybe;
			}
		}
		
		return null;
	}
}
