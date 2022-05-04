package pl.edu.mimuw.logic;

import pl.edu.mimuw.logic.*;
import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SolverTest {

  @Test
  void testNoMatchingVariables() {
    // (x && true) && (x && false)
    Formula x = FormulaFactory.var("x");
    Formula true1 = FormulaFactory.t();
    Formula false1 = FormulaFactory.f();
    Formula and1 = FormulaFactory.iff(x, true1);
    Formula and2 = FormulaFactory.iff(x, false1);
    Formula finalFormula = FormulaFactory.and(and1, and2);
    System.out.println(finalFormula.toString());

    var resulting = Solver.getCorrectValuation(finalFormula);
    assertEquals(resulting, null);
  }
  @Test
  void testFormulaIff(){
  // (x <=> y) <=> (y <=> false)
    Formula x = FormulaFactory.var("x");
    Formula y = FormulaFactory.var("y");
    Formula false1 = FormulaFactory.f();
    Formula iff1 = FormulaFactory.iff(x, y);
    Formula iff2 = FormulaFactory.iff(x, false1);
    Formula finalFormula = FormulaFactory.iff(iff1, iff2);
    System.out.println(finalFormula.toString());
    var correctAnswer = new HashMap<String, Boolean>();
    correctAnswer.put("x", false);
    correctAnswer.put("y", true);
    var resulting = Solver.getCorrectValuation(finalFormula);
    assertEquals(resulting, correctAnswer);
  }

  @Test
  void testFormulaImplies(){
    // ((p => r) => (r => s)) => (s => false))
    Formula p = FormulaFactory.var("p");
    Formula r = FormulaFactory.var("r");
    Formula s = FormulaFactory.var("s");
    Formula false1 = FormulaFactory.f();
    Formula imp1 = FormulaFactory.implies(p, r);
    Formula imp2 = FormulaFactory.implies(r, s);
    Formula imp3 = FormulaFactory.implies(s, false1);
    Formula imp4 = FormulaFactory.implies(imp1, imp2);
    Formula finalFormula = FormulaFactory.implies(imp4, imp3);
    System.out.println(finalFormula.toString());
    var correctAnswer = new HashMap<String, Boolean>();
    correctAnswer.put("p", false);
    correctAnswer.put("r", false);
    correctAnswer.put("s", false);
    var resulting = Solver.getCorrectValuation(finalFormula);
    assertEquals(resulting, correctAnswer);
  }
}
