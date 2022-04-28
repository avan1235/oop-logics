package pl.edu.mimuw.logic.formulas.duble;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

public class iffFormula extends doubleFormulaA {

  public iffFormula(Formula l, Formula r) {
    super(l, r, "<=>");
  }

  public boolean eval(Valuation valuation) {
    return l.eval(valuation) == r.eval(valuation);
  }
}
