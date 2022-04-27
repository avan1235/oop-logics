package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class SolverTest {

  @Test
  void testFormulaButChangeThisFunctionNameOKIDid() {
      var p = FormulaFactory.var("p");
      var q = FormulaFactory.var("q");
      var two = FormulaFactory.iff(p, q);
      var t = FormulaFactory.t();
      var f = FormulaFactory.f();
      var compareToT = FormulaFactory.iff(two,t);
      var compareToF = FormulaFactory.iff(two,f);
      var all = FormulaFactory.iff(compareToT, compareToF);
      
      assertEquals(Solver.solve(all), null);
  }

  @Test
  void simpleTestForNotNull() {
      var p = FormulaFactory.var("p");
      var q = FormulaFactory.var("q");
      var two = FormulaFactory.iff(p, q);
      
      assertEquals(Solver.solve(two), null);
  }
}
