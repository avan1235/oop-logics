package pl.edu.mimuw.logic;

public final class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula and(Formula l, Formula formula) {
    return new And(l, formula);
  }

  public static Formula or(Formula l, Formula formula) {
    return new Or(l, formula);
  }

  public static Formula implies(Formula l, Formula formula) {
    return new Implication(l, formula);
  }

  public static Formula iff(Formula l, Formula formula) {
    return new Iff(l, formula);
  }

  public static Formula not(Formula formula) {
    return new Not(formula);
  }

  public static Formula not(String name) {
    return new Not(new Variable(name));
  }

  public static Variable var(String name) {
    return new Variable(name);
  }

  public static Formula t() {
    return new Const(true);
  }

  public static Formula f() {
    return new Const(false);
  }
}
