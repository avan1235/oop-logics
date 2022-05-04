package pl.edu.mimuw.logic;

import java.util.List;

public class ConstFormula implements Formula
{
	private final boolean value;

	public ConstFormula(boolean _value)
	{
		value = _value;
	}

	@Override
	public String toString()
	{
		return (value ? "true" : "false");
	}

	@Override
	public boolean eval(Valuation valuation)
	{
		return value;
	}

	@Override
	public List <String> getVariables()
	{
		return null;
	}
}