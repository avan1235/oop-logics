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

  public static Formula implies(Formula l, Formula formula) {
    return new Implies(l, formula);
  }

  public static Formula iff(Formula l, Formula formula) {
    return new Iff(l, formula);
  }

  public static Formula not(Formula l) {
    return new Not(l);
  }

  public static Formula var(String name) {
    return new FormulaVariable(name);
  }

  public static Formula t() {
    return new FormulaConstant(true);
  }

  public static Formula f() {
    return new FormulaConstant(false);
  }
}
