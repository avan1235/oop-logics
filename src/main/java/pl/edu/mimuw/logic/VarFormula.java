package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VarFormula implements Formula
{
	private final String variableName;

	public VarFormula(String _variableName)
	{
		variableName = _variableName;
	}

	@Override
	public String toString()
	{
		return variableName;
	}

	@Override
	public boolean eval(Valuation valuation)
	{
		return valuation.getValue(variableName);
	}

	@Override
	public List <String> getVariables()
	{
		return new ArrayList <>(Collections.singleton(variableName));
	}
}