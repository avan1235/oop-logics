package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolverTest {
  private final FormulaFactory f = new FormulaFactory();
  private final Solver solver = new Solver();

  private boolean testAns(Formula formula) {
    Valuation valuation = new Valuation();

    var vals = formula.getVars().toArray(new String[0]);
    var val = solver.solve(formula);
    for (int i = 0; i < vals.length; i++) {
      valuation.SetValue(vals[i], val[i]);
    }

    return formula.eval(valuation);
  }

  @Test
  void testAndFormula() {
    var andForm = f.and(f.var("l"), f.var("r"));

    assertTrue(Arrays.equals(solver.solve(andForm), new boolean[]{true, true}));
    assertTrue(testAns(andForm));
  }

  @Test
  void testMultipleFormulas() {
    var iffForm = f.and(f.var("l"), f.var("r"));
    var orForm = f.or(f.var("l"), f.var("r"));
    var impForm = f.iff(f.f(), f.implies(orForm, iffForm));

    assertTrue(Arrays.equals(solver.solve(impForm), new boolean[]{false, true}));
    assertTrue(testAns(impForm));
  }

  @Test
  void testMultipleVars() {
    var and = f.and(f.var("x"), f.var("y"));
    var and2 = f.and(f.var("z"), f.var("m"));
    var impForm2 = f.implies(f.t(), f.and(and, and2));

    assertTrue(Arrays.equals(solver.solve(impForm2), new boolean[]{true, true, true, true}));
    assertTrue(testAns(impForm2));
  }

  @Test
  void testLogForm() {
    var iffForm = f.and(f.var("l"), f.var("r"));
    var orForm = f.or(f.var("l"), f.var("r"));
    var impForm = f.iff(f.f(), f.implies(orForm, iffForm));
    var and = f.and(f.var("x"), f.var("y"));
    var and2 = f.and(f.var("z"), f.var("m"));
    var impForm2 = f.implies(f.t(), f.and(and, and2));
    var form = f.and(impForm, impForm2);

    assertTrue(Arrays.equals(solver.solve(form), new boolean[]{false, true, true, true, true, true}));
    assertTrue(testAns(form));
  }
}
