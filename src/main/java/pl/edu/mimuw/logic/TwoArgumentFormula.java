package pl.edu.mimuw.logic;

import java.util.List;

public abstract class TwoArgumentFormula implements Formula
{
	protected final Formula leftKid;
	protected final Formula rightKid;

	public TwoArgumentFormula(Formula _leftKid, Formula _rightKid)
	{
		leftKid = _leftKid;
		rightKid = _rightKid;
	}

	@Override
	public List <String> getVariables()
	{
		List <String> tmp = leftKid.getVariables();
		if (tmp == null)
			return rightKid.getVariables();
		tmp.addAll(rightKid.getVariables());
		return tmp;
	}

	@Override
	public abstract String toString();
}