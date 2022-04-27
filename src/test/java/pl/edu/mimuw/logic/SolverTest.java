package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;
import pl.edu.mimuw.Solver;

class SolverTest {

  @Test
  void testSolverNoSolution() {
    Formula formula = FormulaFactory.or(FormulaFactory.f(), FormulaFactory.and(FormulaFactory.var("x"), FormulaFactory.not(FormulaFactory.var("x"))));
    try{
      Solver.solve(formula);
      assert(false);
    }catch(Exception e){}
  }
  @Test
  void testSolverAlwaysTrue() {
    Formula formula = FormulaFactory.or(FormulaFactory.var("x"), FormulaFactory.not(FormulaFactory.var("x")));
    formula = FormulaFactory.implies(formula, FormulaFactory.or(FormulaFactory.var("y"), FormulaFactory.not(FormulaFactory.var("y"))));
    try{
      Solver.solve(formula);
    }catch(Exception e){
      assert(false);}
  }
  @Test
  void testSolverOneSolution() {
    Formula formula = FormulaFactory.iff(FormulaFactory.var("x"), FormulaFactory.not(FormulaFactory.var("y")));
    formula = FormulaFactory.and(formula, FormulaFactory.implies(FormulaFactory.var("y"), FormulaFactory.var("x")));
    try{
      Valuation valuation = Solver.solve(formula);
      assert(valuation.getValue("x"));
      assert(!valuation.getValue("y"));
    }catch(Exception e){
      assert(false);
    }
  }
}
