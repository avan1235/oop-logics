package pl.edu.mimuw.logic;

public class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula and(Formula l, Formula r) {
    return new And(l, r);
  }

  public static Formula or(Formula l, Formula r) {
    return new Or(l, r);
  }

  public static Formula implies(Formula l, Formula r) {
    return new Implies(l, r);
  }

  public static Formula iff(Formula l, Formula r) {
    return new Iff(l, r);
  }

  public static Formula not(Formula f) {
    return new Not(f);
  }

  public static Formula var(String name) {
    return new Variable(name);
  }

  public static Formula t() {
    return new Constant(true);
  }

  public static Formula f() {
    return new Constant(false);
  }
}
