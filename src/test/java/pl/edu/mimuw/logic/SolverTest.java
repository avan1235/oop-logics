package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class SolverTest
{
	@Test
	void testFormula1() // p ^ q => p - prawo pochłaniania
	{
		Formula formula = FormulaFactory.implies(FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("q")), FormulaFactory.var("p"));
		Assertions.assertNotNull(Solver.solve(formula));
	}

	@Test
	void testFormula2() // p ^ (q v r) <=> (p ^ q) v (p ^ r) - prawo rozdzielności koniunkcji względem alternatywy
	{
		Formula formula = FormulaFactory.iff(FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.or(FormulaFactory.var("q"), FormulaFactory.var("r"))), FormulaFactory.or(FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("q")), FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("r"))));
		Assertions.assertNotNull(Solver.solve(formula));
	}

	@Test
	void testFormula3() // z fałszu może wynikać cokolwiek
	{
		Formula formula = FormulaFactory.implies(FormulaFactory.f(), FormulaFactory.t());
		Assertions.assertNotNull(Solver.solve(formula));
	}

	@Test
	void testFormula4() // p => p ^ q - jeżeli q = true, to to jest prawdziwe
	{
		Formula formula = FormulaFactory.implies(FormulaFactory.var("p"), FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("q")));
		Assertions.assertNotNull(Solver.solve(formula));
	}

	@Test
	void testFormula5() // prawda jest różna od fałszu
	{
		Formula formula = FormulaFactory.iff(FormulaFactory.t(), FormulaFactory.f());
		Assertions.assertNull(Solver.solve(formula));
	}
}