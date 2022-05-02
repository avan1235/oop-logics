package pl.edu.mimuw.logic;

public class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula and(Formula l, Formula formula) {
    return new Conjuction(l, formula);
  }

  public static Formula or(Formula l, Formula formula) {
    return new Disjunction(l, formula);
  }

  public static Formula implies(Formula l, Formula formula) {
    return new Disjunction(new Negation(l), formula);
  }

  public static Formula iff(Formula l, Formula formula) {
    return new Conjuction(implies(l, formula), implies(formula, l));
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
