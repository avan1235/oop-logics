package pl.edu.mimuw.logic;

public class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula not(Formula formula) {
    return new NotFormula(formula);
  }

  public static Formula and(Formula l, Formula formula) {
    return new AndFormula(l, formula);
  }

  public static Formula or(Formula l, Formula formula) {
    return new OrFormula(l, formula);
  }

  public static Formula implies(Formula l, Formula formula) {
    return new ImpliesFormula(l, formula);

  }

  public static Formula iff(Formula l, Formula formula) {
    return new IffFormula(l, formula);
  }

  public static Formula var(String name) {
    return new VariableFormula(name);
  }

  public static Formula t() {
    return new ValueFormula(true);
  }

  public static Formula f() {
    return new ValueFormula(false);
  }
}
