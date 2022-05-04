package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.FormulaFactory;

public class Main
{
	public static void main(String[] args)
	{
		Formula formula1 = FormulaFactory.implies(FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("q")), FormulaFactory.var("p"));
		System.out.println(formula1);

		Formula formula2 = FormulaFactory.iff(FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.or(FormulaFactory.var("q"), FormulaFactory.var("r"))), FormulaFactory.or(FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("q")), FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("r"))));
		System.out.println(formula2);

		Formula formula3 = FormulaFactory.implies(FormulaFactory.f(), FormulaFactory.t());
		System.out.println(formula3);
	}
}
