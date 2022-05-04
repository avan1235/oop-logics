package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

class SolverTest {

  @Test
  void testHamlet() {
    Formula hamlet = FormulaFactory.or(new Var("to_be"), FormulaFactory.neg(new Var("to_be")));
    Valuation tempV = Solver.solve(hamlet);
    assert(hamlet.eval(tempV));
  }

  @Test
  void testPMat() {
    Var p = new Var("p");
    Var q = new Var("q");
    Formula testPMat1 = FormulaFactory.implies(FormulaFactory.implies(FormulaFactory.implies(p, q), q), p);
    Valuation tempV = Solver.solve(testPMat1);
    assert(testPMat1.eval(tempV));
  }

}

