package pl.edu.mimuw.logic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.mimuw.logic.FormulaFactory.*;
import static pl.edu.mimuw.logic.Solver.*;
import org.junit.jupiter.api.Test;

class SolverTest {

  @Test
  void contradiction() {
    boolean exp = false;
    Variable v = var("v");
    Formula f = and(v, not(v));
    Solution s = solution(f);
  }

  @Test
  void manyImplications() {
    var v = var("v");
    var f = implies(v,f());
    for(int i = 0; i < 20; i++) {
      f =  implies(v, f);
    }
    var s = solution(f);
    var exp = new Valuation();
    exp.setValue(v, false);
    assertEquals(exp.readValue(v), s.getValuation().readValue(v));
  }

  @Test
  void oneSolution() {
    var x = var("x");
    var y = var("y");
    var z = var("z");
    var a = implies(x,y);
    var b = implies(y,x);
    var c = iff(x,f());
    var d = not(iff(y,z));
    var form = and(and(and(a,b),c),d);
    var s = solution(form);
    var exp = new Valuation();
    exp.setValue(x, false);
    exp.setValue(y, false);
    exp.setValue(z, true);
    assertEquals(exp.readValue(x), s.getValuation().readValue(x));
    assertEquals(exp.readValue(y), s.getValuation().readValue(y));
    assertEquals(exp.readValue(z), s.getValuation().readValue(z));
  }
}
