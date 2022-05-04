package pl.edu.mimuw.logic;

public class AndFormula extends TwoArgumentFormula
{
	public AndFormula(Formula _leftKid, Formula _rightKid)
	{
		super(_leftKid, _rightKid);
	}

	@Override
	public String toString()
	{
		return "(" + leftKid.toString() + " and " + rightKid.toString() + ")";
	}

	@Override
	public boolean eval(Valuation valuation)
	{
		return leftKid.eval(valuation) & rightKid.eval(valuation);
	}
}