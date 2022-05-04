package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;
import pl.edu.mimuw.Solver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.mimuw.logic.FormulaFactory.*;

class SolverTest {

  @Test
  void testNoSolution() {
    //(a & b & x & c & ~x)
    final Formula f = and(
      and(
        var("a"),
        var("b")
      ),
      and(
        and(
          var("x"),
          var("c")
        ),
        not(var("x"))
      )
    );

    final Valuation solution = Solver.solve(f);

    assertEquals(solution, null);
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

    assertEquals(solution.get("a"), true);
    assertEquals(solution.get("b"), true);
  }

  @Test
  void testMultipleNegations() {
    final Formula x = var("x");
    final Formula doubleNegation = not(not(x));
    final Formula tripleNegation = not(doubleNegation);

    final Valuation solution = Solver.solve(x);
    final Valuation solution2 = Solver.solve(doubleNegation);
    final Valuation solution3 = Solver.solve(tripleNegation);

    assertEquals(solution.get("x"), true);
    assertEquals(solution2.get("x"), true);
    assertEquals(solution3.get("x"), false);
  }

}
