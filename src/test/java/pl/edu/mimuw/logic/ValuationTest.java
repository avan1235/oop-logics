package pl.edu.mimuw.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValuationTest {

  @Test
  void testValuation() {
    final var v = new Valuation();

    v.add(FormulaFactory.var("x"), true);
    v.add(FormulaFactory.var("y"), false);
    v.add(FormulaFactory.var("z"), true);

    assertTrue(v.getValue(FormulaFactory.var("x")));
    assertFalse(v.getValue(FormulaFactory.var("y")));
    assertTrue(v.getValue(FormulaFactory.var("z")));
    assertThrows(NullPointerException.class, () -> v.getValue(FormulaFactory.var("w")));
  }

  @Test
  void testImplication() {
    final var v = new Valuation();

    v.add(FormulaFactory.var("x"), true);
    v.add(FormulaFactory.var("y"), false);

    assertTrue(FormulaFactory.implies(FormulaFactory.var("x"), FormulaFactory.var("x")).eval(v));
    assertFalse(FormulaFactory.implies(FormulaFactory.var("x"), FormulaFactory.var("y")).eval(v));
    assertTrue(FormulaFactory.implies(FormulaFactory.var("y"), FormulaFactory.var("x")).eval(v));
    assertTrue(FormulaFactory.implies(FormulaFactory.var("y"), FormulaFactory.var("y")).eval(v));
  }

  @Test
  void testIff() {
    final var v = new Valuation();

    v.add(FormulaFactory.var("x"), true);
    v.add(FormulaFactory.var("y"), false);

    assertTrue(FormulaFactory.iff(FormulaFactory.var("x"), FormulaFactory.var("x")).eval(v));
    assertFalse(FormulaFactory.iff(FormulaFactory.var("x"), FormulaFactory.var("y")).eval(v));
    assertFalse(FormulaFactory.iff(FormulaFactory.var("y"), FormulaFactory.var("x")).eval(v));
    assertTrue(FormulaFactory.iff(FormulaFactory.var("y"), FormulaFactory.var("y")).eval(v));
  }

  @Test
  void testAnd() {
    final var v = new Valuation();

    v.add(FormulaFactory.var("x"), true);
    v.add(FormulaFactory.var("y"), false);

    assertTrue(FormulaFactory.and(FormulaFactory.var("x"), FormulaFactory.var("x")).eval(v));
    assertFalse(FormulaFactory.and(FormulaFactory.var("x"), FormulaFactory.var("y")).eval(v));
    assertFalse(FormulaFactory.and(FormulaFactory.var("y"), FormulaFactory.var("x")).eval(v));
    assertFalse(FormulaFactory.and(FormulaFactory.var("y"), FormulaFactory.var("y")).eval(v));
  }

  @Test
  void testOr() {
    final var v = new Valuation();

    v.add(FormulaFactory.var("x"), true);
    v.add(FormulaFactory.var("y"), false);

    assertTrue(FormulaFactory.or(FormulaFactory.var("x"), FormulaFactory.var("x")).eval(v));
    assertTrue(FormulaFactory.or(FormulaFactory.var("x"), FormulaFactory.var("y")).eval(v));
    assertTrue(FormulaFactory.or(FormulaFactory.var("y"), FormulaFactory.var("x")).eval(v));
    assertFalse(FormulaFactory.or(FormulaFactory.var("y"), FormulaFactory.var("y")).eval(v));
  }

  @Test
  void testNot() {
    final var v = new Valuation();

    v.add(FormulaFactory.var("x"), true);
    v.add(FormulaFactory.var("y"), false);

    assertFalse(FormulaFactory.not(FormulaFactory.var("x")).eval(v));
    assertTrue(FormulaFactory.not(FormulaFactory.var("y")).eval(v));
  }

  @Test
  void testComplicatedFormula() {
    final var v = new Valuation();

    v.add(FormulaFactory.var("p"), true);
    v.add(FormulaFactory.var("q"), false);
    v.add(FormulaFactory.var("r"), false);
    v.add(FormulaFactory.var("s"), true);

    final var f1 = FormulaFactory.implies(FormulaFactory.var("p"), FormulaFactory.var("r"));
    final var f2 = FormulaFactory.implies(FormulaFactory.var("q"), FormulaFactory.var("s"));
    final var f3 = FormulaFactory.and(f1, f2);
    final var f4 = FormulaFactory.or(FormulaFactory.not("p"), FormulaFactory.not("s"));
    final var f5 = FormulaFactory.or(FormulaFactory.not("p"), FormulaFactory.not("q"));
    final var f6 = FormulaFactory.implies(f4, f5);
    final var f7 = FormulaFactory.and(f3, f6);

    assertFalse(f7.eval(v));
  }
}
