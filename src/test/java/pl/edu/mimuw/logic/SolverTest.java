package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pl.edu.mimuw.logic.FormulaFactory.*;

class SolverTest {

  @Test
  void noSolution() {
    // (p ∨ q) ↔ ¬((p → q) → q) is always false
    Formula p = var("p");
    Formula q = var("q");
    Formula f1 = or(p, q);
    Formula f2 = implies(p, q);
    Formula f3 = implies(f2, q);
    Formula noSol = iff(f1, not(f3));
    Valuation res = Solver.solveBrutally(noSol);

    assertNull(res);
  }

  @Test
  void onlyOneSolution() {
    /* ¬(p ↔ q) ∧ ((¬q → (p ∨ (r ∨ z))) → (p ∧ (¬q ∧ (r ∧ z))))
      is true iff p->true q->false p->true z->true */
    Formula p = var("p");
    Formula q = var("q");
    Formula r = var("r");
    Formula z = var("z");

    // f1: ¬(p ↔ q)
    Formula f1 = not(iff(p, q));

    // f2: (¬q → (p ∨ (r ∨ z)))
    Formula f2 = implies(not(q), or(p, or(r, z)));

    // f3: (p ∧ (¬q ∧ (r ∧ z)))
    Formula f3 = and(p, and(not(q), and(r, z)));

    // formula: f1 ∧ (f2 → f3)
    Formula formula = and(f1, implies(f2, f3));

    Valuation res = Solver.solveBrutally(formula);

    assert res != null;
    assertTrue(res.get("p"));
    assertFalse(res.get("q"));
    assertTrue(res.get("r"));
    assertTrue(res.get("z"));
  }

  @Test
  void nestedNegatedImplication() {
    // ¬(p0 → (p1 → (p2 → (p3 → (p4 → p5))))) true iff all true except p5
    Formula acc = var("p5");
    for (int i = 4; i >= 0; i--) {
      acc = implies(var("p" + i), acc);
    }
    acc = not(acc);

    Valuation res = Solver.solveBrutally(acc);

    assert res != null;
    for (int i = 0; i < 5; i++)
      assertTrue(res.get("p" + i));

    assertFalse(res.get("p5"));
  }

  @Test
  void negatedTautology() {
    // ¬((p → q ∨ r) → (¬((p → q) ∨ r) → (p → q)))
    // On pmat students were f̶o̶r̶c̶e̶d̶ asked to prove this using natural deduction. 0/10 would not recommend.

    Formula p = var("p");
    Formula q = var("q");
    Formula r = var("r");

    // f1: (p → q ∨ r)
    Formula f1 = implies(p, or(q, r));

    // f2: ¬((p → q) ∨ r)
    Formula f2 = not(or(implies(p, q), r));

    // f3: (p → q)
    Formula f3 = implies(p, q);

    // formula: ¬(f1 → (f2 → f3))
    Formula formula = not(implies(f1, implies(f2, f3)));

    Valuation res = Solver.solveBrutally(formula);

    assertNull(res);
  }
}
