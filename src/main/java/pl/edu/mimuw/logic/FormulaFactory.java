package pl.edu.mimuw.logic;

public class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula and(Formula l, Formula formula) {
    return new And("and", l, formula);
  }

  public static Formula or(Formula l, Formula formula) {
    return new Or("or", l, formula);
  }

  public static Formula not(Formula l) {
    return new Not("not", l);
  }


  public static Formula implies(Formula l, Formula formula) {
    return FormulaFactory.or(FormulaFactory.not(l), formula);
  }

  public static Formula iff(Formula l, Formula formula) {
    return FormulaFactory.and(FormulaFactory.implies(l, formula), FormulaFactory.implies(formula, l));
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
