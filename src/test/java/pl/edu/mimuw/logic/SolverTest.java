package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;
import pl.edu.mimuw.Formula;

import static pl.edu.mimuw.FormulaFactory.evaluate;

class SolverTest {

  @Test
  void testFormula(Formula f) {
    evaluate(f);
  }
}
