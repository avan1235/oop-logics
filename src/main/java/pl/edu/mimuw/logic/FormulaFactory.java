package pl.edu.mimuw.logic;

import pl.edu.mimuw.logic.formulas.duble.andFormula;
import pl.edu.mimuw.logic.formulas.duble.iffFormula;
import pl.edu.mimuw.logic.formulas.duble.impliesFormula;
import pl.edu.mimuw.logic.formulas.duble.orFormula;
import pl.edu.mimuw.logic.formulas.single.fFormula;
import pl.edu.mimuw.logic.formulas.single.tFormula;
import pl.edu.mimuw.logic.formulas.single.varFormula;

public class FormulaFactory {

  public FormulaFactory() {
  }

  public static Formula and(Formula l, Formula formula) {
    return new andFormula(l, formula);
  }

  public static Formula or(Formula l, Formula formula) {
    return new orFormula(l, formula);
  }

  public static Formula implies(Formula l, Formula formula) {
    return new impliesFormula(l, formula);
  }

  public static Formula iff(Formula l, Formula formula) {
    return new iffFormula(l, formula);
  }

  public static Formula var(String name) {
    return new varFormula(name);
  }

  public static Formula t() {
    return new tFormula();
  }

  public static Formula f() {
    return new fFormula();
  }
}
