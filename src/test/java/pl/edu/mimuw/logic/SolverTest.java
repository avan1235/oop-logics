package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

  @Test
  void testEasySolve() {
    final var f1 = FormulaFactory.and(FormulaFactory.var("p"), FormulaFactory.var("q"));
    final var f2 = FormulaFactory.and(f1, FormulaFactory.not("r"));

    final var solution = Solver.anySolve(f2);

    assertNotNull(solution);
    assertTrue(f2.eval(solution));
  }

  @Test
  void testEasySolveWithConst() {
    final var f1 = FormulaFactory.and(FormulaFactory.not("p"), FormulaFactory.var("q"));
    final var f2 = FormulaFactory.or(f1, FormulaFactory.f());

    final var solution = Solver.anySolve(f2);

    assertNotNull(solution);
    assertTrue(f2.eval(solution));
  }

  @Test
  void testNoSolveWithConst() {
    final var f1 = FormulaFactory.and(FormulaFactory.not("p"), FormulaFactory.var("q"));
    final var f2 = FormulaFactory.and(f1, FormulaFactory.f());

    assertNull(Solver.anySolve(f2));
  }

  @Test
  void testSolveALotOfVariablesAllFalse() {
    final var f1 = FormulaFactory.and(FormulaFactory.not("p"), FormulaFactory.not("q"));
    final var f2 = FormulaFactory.and(f1, FormulaFactory.not("r"));
    final var f3 = FormulaFactory.and(f2, FormulaFactory.not("s"));
    final var f4 = FormulaFactory.and(f3, FormulaFactory.not("t"));
    final var f5 = FormulaFactory.and(f4, FormulaFactory.not("u"));
    final var f6 = FormulaFactory.and(f5, FormulaFactory.not("v"));
    final var f7 = FormulaFactory.and(f6, FormulaFactory.not("w"));
    final var f8 = FormulaFactory.and(f7, FormulaFactory.not("x"));
    final var f9 = FormulaFactory.and(f8, FormulaFactory.not("y"));
    final var f10 = FormulaFactory.and(f9, FormulaFactory.not("z"));

    final var solution = Solver.anySolve(f10);
    assertNotNull(solution);
    assertTrue(f10.eval(solution));
  }

  @Test
  void testComplicatedNoSolve() {
    final var f1 = FormulaFactory.implies(FormulaFactory.var("p"), FormulaFactory.var("q"));
    final var f2 = FormulaFactory.implies(f1, FormulaFactory.var("r"));
    final var f3 = FormulaFactory.implies(FormulaFactory.var("q"), FormulaFactory.var("r"));
    final var f4 = FormulaFactory.implies(f3, FormulaFactory.var("r"));
    final var f5 = FormulaFactory.implies(f4, FormulaFactory.var("r"));
    final var f6 = FormulaFactory.not(f5);
    final var f7 = FormulaFactory.and(f2, f6);

    assertNull(Solver.anySolve(f7));
  }

  @Test
  void testMediocreSolve() {
    final var f1 = FormulaFactory.implies(FormulaFactory.var("p"), FormulaFactory.var("q"));
    final var f2 = FormulaFactory.implies(FormulaFactory.var("q"), FormulaFactory.var("r"));
    final var f3 = FormulaFactory.or(f1, f2);

    final var solution = Solver.anySolve(f3);
    assertNotNull(solution);
    assertTrue(f3.eval(solution));
  }

  @Test
  void testComplicatedSolve() {
    final var f1 = FormulaFactory.implies(FormulaFactory.var("p"), FormulaFactory.var("q"));
    final var f2 = FormulaFactory.implies(FormulaFactory.not("p"), FormulaFactory.var("r"));
    final var f3 = FormulaFactory.implies(FormulaFactory.var("r"), FormulaFactory.not("q"));
    final var f4 = FormulaFactory.implies(f2, f3);
    final var f5 = FormulaFactory.and(f1, f4);

    final var solution = Solver.anySolve(f5);
    assertNotNull(solution);
    assertTrue(f5.eval(solution));
  }

  @Test
  void testSolveNoVariables() {
    final var f1 = FormulaFactory.and(FormulaFactory.t(), FormulaFactory.t());

    final var solution = Solver.anySolve(f1);

    assertNotNull(solution);
    assertTrue(f1.eval(solution));
  }

  @Test
  void testNoSolveNoVariables() {
    final var f1 = FormulaFactory.and(FormulaFactory.t(), FormulaFactory.f());

    final var solution = Solver.anySolve(f1);

    assertNull(solution);
    assertFalse(f1.eval(solution));
  }
}
