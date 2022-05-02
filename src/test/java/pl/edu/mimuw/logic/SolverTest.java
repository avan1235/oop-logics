package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
class SolverTest {

  @Test
  void testComparingToTrueAndFalse() {
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
      
      assertNotEquals(Solver.solve(two), null);
  }

  @Test
  void testWithEqualitiesAndAnds() {
    var p = FormulaFactory.var("p");
    var q = FormulaFactory.var("q");
    var r = FormulaFactory.var("r");
    var s = FormulaFactory.var("s");
    var no = FormulaFactory.f();
    var yes = FormulaFactory.t();
    var ris0 = FormulaFactory.iff(no, r);
    var pis1 = FormulaFactory.iff(yes, p);
    var both = FormulaFactory.and(ris0, pis1);
    var qis1 = FormulaFactory.iff(yes, q);
    var sis0 = FormulaFactory.iff(no, s);
    var both2 = FormulaFactory.and(qis1, sis0);
    var all2 = FormulaFactory.and(both, both2);
    Map<String,Boolean> map = new HashMap<String,Boolean>();
    map.put("r", false);
    map.put("s", false);
    map.put("p", true);
    map.put("q", true);
    assertEquals(map, Solver.solve(all2).getMap()); //equals na mapach jest zdefiniowane sensownie
  }
}
