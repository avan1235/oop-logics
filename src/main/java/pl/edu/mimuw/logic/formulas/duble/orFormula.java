package pl.edu.mimuw.logic.formulas.duble;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

public class orFormula extends doubleFormulaA {

  public orFormula(Formula l, Formula r) {
    super(l, r, "||");
  }

  public boolean eval(Valuation valuation) {
    return l.eval(valuation) || r.eval(valuation);
  }
}