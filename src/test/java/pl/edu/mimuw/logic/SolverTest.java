package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

class SolverTest {

  @Test
  void simpleFormulaTest() {
    // (y or T) => (x and y)
    Variable varX = (Variable) FormulaFactory.var("x");
    Variable varY = (Variable) FormulaFactory.var("y");
    var formula = FormulaFactory.implies(FormulaFactory.or(varY, FormulaFactory.t()),
      FormulaFactory.and(varX, varY));
    var solver = new Solver(formula);
    var solution = solver.solve();
    assert(solution.getValue(varX));
    assert(solution.getValue(varY));
    assert(solution.getValues().size() == 2);
  }

  @Test
  void tautologyTest() {
    // a => b => c => d => T
    Variable varA = (Variable) FormulaFactory.var("a");
    Variable varB = (Variable) FormulaFactory.var("b");
    Variable varC = (Variable) FormulaFactory.var("c");
    Variable varD = (Variable) FormulaFactory.var("d");

    var formula = FormulaFactory.implies(varA, FormulaFactory.implies(varB, FormulaFactory.implies(varC,
      FormulaFactory.implies(varD, FormulaFactory.t()))));

    var solver = new Solver(formula);
    var solution = solver.solve();
    assert(solution.getValues().size() == 0);
  }

  @Test
  void iffTest() {
    // a <=> b <=> c <=> d <=> T
    Variable varA = (Variable) FormulaFactory.var("a");
    Variable varB = (Variable) FormulaFactory.var("b");
    Variable varC = (Variable) FormulaFactory.var("c");
    Variable varD = (Variable) FormulaFactory.var("d");

    var formula = FormulaFactory.iff(varA, FormulaFactory.iff(varB, FormulaFactory.iff(varC, FormulaFactory.iff(varD, FormulaFactory.t()))));

    var solver = new Solver(formula);
    var solution = solver.solve();
    assert(solution.getValues().size() == 4);
    assert(!solution.getValue(varA));
    assert(!solution.getValue(varB));
    assert(!solution.getValue(varC));
    assert(!solution.getValue(varD));
  }
}
