package pl.edu.mimuw.logic;

public class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula and(Formula l, Formula formula) {
    return new And(l, formula);
  }

  public static Formula or(Formula l, Formula formula) {
    return new Or(l, formula);
  }

  public static Formula neg(Formula formula){
    return new Neg(formula);
  }

  public static Formula implies(Formula l, Formula formula) {
    return or( neg(formula), l);
  }

  public static Formula iff(Formula l, Formula formula) {
    return and(implies(l, formula), implies(formula, l));
  }

  public static Formula var(String name) {
    throw new IllegalStateException("TODO");
  }

  public static Formula t() {
    return new Const(true);
  }

  public static Formula f() {
    return new Const(false);
  }
}
