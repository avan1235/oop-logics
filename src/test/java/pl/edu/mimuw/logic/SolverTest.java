package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

  @Test
  void noSolution() {
    // (p ∨ q) ↔ ¬((p → q) → q) is always false
    Formula p = FormulaFactory.var("p");
    Formula q = FormulaFactory.var("q");
    Formula f1 = FormulaFactory.or(p, q);
    Formula f2 = FormulaFactory.implies(p, q);
    Formula f3 = FormulaFactory.implies(f2, q);
    Formula noSol = FormulaFactory.iff(f1, FormulaFactory.not(f3));
    Valuation res = Solver.solveBrutally(noSol);

    assertNull(res);
  }

  @Test
  void onlyOneSolution() {
    /* ¬(p ↔ q) ∧ ((¬q → (p ∨ (r ∨ z))) → (p ∧ (¬q ∧ (r ∧ z))))
      is true iff p->true q->false p->true z->true */
    Formula p = FormulaFactory.var("p");
    Formula q = FormulaFactory.var("q");
    Formula r = FormulaFactory.var("r");
    Formula z = FormulaFactory.var("z");

    // f1: ¬(p ↔ q)
    Formula f1 = FormulaFactory.not(FormulaFactory.iff(p, q));

    // f2: (¬q → (p ∨ (r ∨ z)))
    Formula f2 = FormulaFactory.implies(FormulaFactory.not(q), FormulaFactory.or(p, FormulaFactory.or(r, z)));

    // f3: (p ∧ (¬q ∧ (r ∧ z)))
    Formula f3 = FormulaFactory.and(p, FormulaFactory.and(FormulaFactory.not(q), FormulaFactory.and(r, z)));

    // formula: f1 ∧ (f2 → f3)
    Formula formula = FormulaFactory.and(f1, FormulaFactory.implies(f2, f3));

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
    Formula acc = FormulaFactory.var("p5");
    for (int i = 4; i >= 0; i--) {
      acc = FormulaFactory.implies(FormulaFactory.var("p" + i), acc);
    }
    acc = FormulaFactory.not(acc);

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

    Formula p = FormulaFactory.var("p");
    Formula q = FormulaFactory.var("q");
    Formula r = FormulaFactory.var("r");

    // f1: (p → q ∨ r)
    Formula f1 = FormulaFactory.implies(p, FormulaFactory.or(q, r));

    // f2: ¬((p → q) ∨ r)
    Formula f2 = FormulaFactory.not(FormulaFactory.or(FormulaFactory.implies(p, q), r));

    // f3: (p → q)
    Formula f3 = FormulaFactory.implies(p, q);

    // formula: ¬(f1 → (f2 → f3))
    Formula formula = FormulaFactory.not(FormulaFactory.implies(f1, FormulaFactory.implies(f2, f3)));

    Valuation res = Solver.solveBrutally(formula);

    assertNull(res);
  }
}
