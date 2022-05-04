package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.Random;

public class FormulaFactory {

  private FormulaFactory() {
  }

  public static Formula and(Formula l, Formula formula) {
    return new Conjunction(l, formula);
  }

  public static Formula or(Formula l, Formula formula) {
    return new Alternative(l, formula);
  }

  public static Formula implies(Formula l, Formula formula) {
    return new Implication(l, formula);
  }

  public static Formula iff(Formula l, Formula formula) {
    return new Equivalence(l, formula);
  }

  public static Formula not(Formula formula) {
    return new Negation(formula);
  }

  public static Formula var(String name) {
    return new Var(name);
  }

  public static Formula t() {
    return new Const(true);
  }

  public static Formula f() {
    return new Const(false);
  }

  public static Valuation newValuationRandom(Formula formula) {
    ArrayList<String> variables = formula.getAllVariables();
    ArrayList<Boolean> values = new ArrayList<Boolean>(variables.size());
    var r = new Random();
    for (var value : values) value = r.nextBoolean();
    return new Valuation(variables, values);
  }
}
