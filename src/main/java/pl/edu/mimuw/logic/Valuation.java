package pl.edu.mimuw.logic;

import java.util.HashMap;

public class Valuation
{
	private HashMap <String, Boolean> values;

	public Valuation()
	{
		values = new HashMap <>();
	}

	public boolean getValue(String string)
	{
		return values.get(string);
	}

	public void setValue(String string, Boolean value)
	{
		values.put(string, value);
	}
}