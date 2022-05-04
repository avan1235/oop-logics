package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolverTest {

  @Test
  void andTest() {
    FormulaVariable a = new FormulaVariable("a");
    FormulaVariable b = new FormulaVariable("b");
    FormulaVariable c = new FormulaVariable("c");
    FormulaVariable d = new FormulaVariable("d");
    FormulaVariable e = new FormulaVariable("e");
    FormulaVariable f = new FormulaVariable("f");

    Formula formula = FormulaFactory.and(a, FormulaFactory.and(b, FormulaFactory.and(c, FormulaFactory.and(d, FormulaFactory.and(e, f)))));

    Solver solver = new Solver(formula);
    Valuation valuation = solver.solve(formula);

    assertTrue(formula.eval(valuation));
  }

  @Test
  void allTest() {
    Formula a = FormulaFactory.var("a");
    Formula b = FormulaFactory.var("b");
    Formula c = FormulaFactory.var("c");
    Formula d = FormulaFactory.var("d");
    Formula e = FormulaFactory.var("e");

    Formula formula = FormulaFactory.and(a, FormulaFactory.iff(b, FormulaFactory.implies(c, FormulaFactory.or(d, FormulaFactory.not(e)))));

    Solver solver = new Solver(formula);
    Valuation valuation = solver.solve(formula);

    assertTrue(formula.eval(valuation));
  }

  @Test
  void iffOfTwoBigFormulasTest() {
    Formula a = FormulaFactory.var("a");
    Formula b = FormulaFactory.var("b");
    Formula c = FormulaFactory.var("c");
    Formula d = FormulaFactory.var("d");
    Formula e = FormulaFactory.var("e");
    Formula f = FormulaFactory.var("f");

    Formula formula1 = FormulaFactory.implies(FormulaFactory.iff(a, FormulaFactory.or(b, FormulaFactory.not(c))), d);
    Formula formula2 = FormulaFactory.or(d, FormulaFactory.not(FormulaFactory.implies(e, f)));

    Formula formula = FormulaFactory.iff(formula1, formula2);

    Solver solver = new Solver(formula);
    Valuation valuation = solver.solve(formula);

    assertTrue(formula.eval(valuation));
  }
}
