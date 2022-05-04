package pl.edu.mimuw.logic;

public class FormulaFactory
{

	private FormulaFactory()
	{
	}

	public static Formula and(Formula left, Formula right)
	{
		return new AndFormula(left, right);
	}

	public static Formula or(Formula left, Formula right)
	{
		return new OrFormula(left, right);
	}

	public static Formula implies(Formula left, Formula right)
	{
		return new ImpliesFormula(left, right);
	}

	public static Formula iff(Formula left, Formula right)
	{
		return new IffFormula(left, right);
	}

	public static Formula var(String name)
	{
		return new VarFormula(name);
	}

	public static Formula t()
	{
		return new ConstFormula(true);
	}

	public static Formula f()
	{
		return new ConstFormula(false);
	}
}
