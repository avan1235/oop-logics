package pl.edu.mimuw.logic;

public class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula and(Formula l, Formula formula) {
    Formula a = new And(l, formula);
    return a;
  }

  public static Formula or(Formula l, Formula formula) {
    Formula o = new Or(l, formula);
    return o;

  }

  public static Formula implies(Formula l, Formula formula) {

    Formula i = new Implies(l, formula);
    return i;
  }

  public static Formula iff(Formula l, Formula formula) {

    Formula i = new Iff(l, formula);
    return i;
  }

  public static Formula var(String name) {

    return new Variable(name);

  }

  public static Formula t() {
    Formula t = new ConstantTrue();
    return t;
  }

  public static Formula f() {
    Formula f = new ConstantFalse();
    return f;
  }
}
