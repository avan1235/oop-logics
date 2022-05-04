package pl.edu.mimuw.logic;

import java.util.List;

public class Solver
{
	public static Valuation solve(Formula formula)
	{
		List <String> variables = formula.getVariables();
		Valuation valuation = new Valuation();
		if (variables == null)
		{
			if (formula.eval(valuation))
				return valuation;
			return null;
		}
		for (int i = 0; i < (1 << variables.size()); i++) //reprezentacja waluacji jako maski bitowe
		{
			for (int j = 0; j < variables.size(); j++)
				valuation.setValue(variables.get(j), (((1 << j) & i) != 0));
			if (formula.eval(valuation)) break;
		}
		if (formula.eval(valuation))
			return valuation;
		return null;
	}
}