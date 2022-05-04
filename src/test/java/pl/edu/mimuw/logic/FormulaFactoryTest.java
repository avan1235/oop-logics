package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FormulaFactoryTest {
  @Test
  public void testTwoConstsRand() {
    var t = FormulaFactory.t();
    var f = FormulaFactory.f();
    var formula0 = FormulaFactory.and(t, t);
    var valuation0 = FormulaFactory.newValuationRandom(formula0);
    assert (formula0.eval(valuation0));
    var formula1 = FormulaFactory.and(t, f);
    var valuation1 = FormulaFactory.newValuationRandom(formula1);
    assertFalse(formula1.eval(valuation1));
    var formula2 = FormulaFactory.or(t, f);
    var valuation2 = FormulaFactory.newValuationRandom(formula2);
    assert (formula2.eval(valuation2));
    var formula3 = FormulaFactory.implies(f, t);
    var valuation3 = FormulaFactory.newValuationRandom(formula3);
    assert (formula3.eval(valuation3));
    var formula4 = FormulaFactory.implies(t, f);
    var valuation4 = FormulaFactory.newValuationRandom(formula4);
    assertFalse(formula4.eval(valuation4));
    var formula5 = FormulaFactory.iff(t, f);
    var valuation5 = FormulaFactory.newValuationRandom(formula5);
    assertFalse(formula4.eval(valuation5));
    var formula6 = FormulaFactory.iff(f, f);
    var valuation6 = FormulaFactory.newValuationRandom(formula6);
    assert (formula6.eval(valuation6));
  }

  @Test
  public void testTwoVariables() {
    var x = FormulaFactory.var("x");
    var y = FormulaFactory.var("y");
    var keys = new ArrayList<String>(2);
    var values = new ArrayList<Boolean>(2);
    keys.add("x");
    keys.add("y");
    values.add(true);
    values.add(false);
    var valuation = new Valuation(keys, values);
    //var vy=FormulaFactory.newValuationRandom(y);
    Formula f0 = FormulaFactory.not(x);
    assertFalse(f0.eval(valuation));
    Formula f1 = FormulaFactory.and(y, f0);
    assertFalse(f1.eval(valuation));
    Formula f2 = FormulaFactory.and(x, y);
    assertFalse(f2.eval(valuation));
    Formula f3 = FormulaFactory.or(f0, f1);
    assertFalse(f3.eval(valuation));
    Formula f4 = FormulaFactory.or(x, y);
    assert (f4.eval(valuation));
    Formula f5 = FormulaFactory.implies(f4, f2);
    assertFalse(f5.eval(valuation));
    Formula f6 = FormulaFactory.implies(f5, f2);
    assert (f6.eval(valuation));
    Formula f7 = FormulaFactory.implies(f5, f6);
    assert (f7.eval(valuation));
    Formula f8 = FormulaFactory.iff(f2, f3);
    assert (f8.eval(valuation));
    Formula f9 = FormulaFactory.iff(f5, f6);
    assertFalse(f9.eval(valuation));
    Formula f10 = FormulaFactory.iff(f6, f7);
    assert (f10.eval(valuation));
  }
}
