package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pl.edu.mimuw.logic.FormulaFactory.*;

class SolverTest {

  @Test
  void SimpleTests() {
    final Formula a = var("a");
    final Formula b = var("b");
    final Formula c = var("c");
    final Formula d = var("d");

    Valuation valuation = new Valuation();
    valuation.setValue("a", true);
    valuation.setValue("b", true);
    valuation.setValue("c", false);
    valuation.setValue("d", false);

    assertTrue(a.eval(valuation));
    assertTrue(b.eval(valuation));
    assertFalse(c.eval(valuation));
    assertFalse(d.eval(valuation));

    final Formula tAndt = and(a, b);
    final Formula tAndf = and(a, d);
    final Formula fAndt = and(c, b);
    final Formula fAndf = and(c, d);

    assertTrue(tAndt.eval(valuation));
    assertFalse(tAndf.eval(valuation));
    assertFalse(fAndt.eval(valuation));
    assertFalse(fAndf.eval(valuation));

    final Formula tOrt = or(a, b);
    final Formula tOrf = or(a, d);
    final Formula fOrt = or(c, b);
    final Formula fOrf = or(c, d);

    assertTrue(tOrt.eval(valuation));
    assertTrue(tOrf.eval(valuation));
    assertTrue(fOrt.eval(valuation));
    assertFalse(fOrf.eval(valuation));

    final Formula tImt = implies(a, b);
    final Formula tImf = implies(a, d);
    final Formula fImt = implies(c, b);
    final Formula fImf = implies(c, d);

    assertTrue(tImt.eval(valuation));
    assertFalse(tImf.eval(valuation));
    assertTrue(fImt.eval(valuation));
    assertTrue(fImf.eval(valuation));

    final Formula tIfft = iff(a, b);
    final Formula tIfff = iff(a, d);
    final Formula fIfft = iff(c, b);
    final Formula fIfff = iff(c, d);

    assertTrue(tIfft.eval(valuation));
    assertFalse(tIfff.eval(valuation));
    assertFalse(fIfft.eval(valuation));
    assertTrue(fIfff.eval(valuation));
  }

  @Test
  void TestsWithMultipleLogicGates() {

    final Formula a = var("a");
    final Formula b = var("b");
    final Formula c = var("c");
    final Formula d = var("d");

    Valuation valuation = new Valuation();
    valuation.setValue("a", true);
    valuation.setValue("b", true);
    valuation.setValue("c", false);
    valuation.setValue("d", false);

    //((a ^ b) v c) => d
    final Formula and = and(a, b);
    final Formula or = or(and, c);
    final Formula imp = implies(or, d);

    assertFalse(imp.eval(valuation));

    //((a ^ c) v d) => b

    Formula and2 = and(a, c);
    Formula or2 = or(and2, d);
    Formula imp2 = implies(or2, b);

    assertTrue(imp2.eval(valuation));
  }

  @Test
  void TestsWithSolver() {
    //a && b
    final Formula Test1 = and(var("p"),var("q"));

    final Valuation solution = Solver.solve(Test1);

    Assertions.assertNotNull(solution);

    //(a->b)->(b->c) - no solution
    final Formula Test2 = implies((implies(var("a"), var("b"))), (implies(var("b"), var("c"))));

    final Valuation solution2 = Solver.solve(Test2);

    assertNull(solution2);
  }

  @Test
  void testImplies() {
    //(a=>b) & (b=>a) & (true => a)
    final Formula f = and(
      and(
        implies(var("a"), var("b")),
        implies(var("b"), var("a"))
      ),
      implies(t(), var("a"))
    );

    final Valuation solution = Solver.solve(f);

    assertTrue(solution.getValue("a"));
    assertTrue(solution.getValue("b"));
  }
}
