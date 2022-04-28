package pl.edu.mimuw.logic.formulas.duble;

import pl.edu.mimuw.logic.Formula;

import java.util.List;
import java.util.Set;

public abstract class doubleFormulaA implements Formula {
  protected final Formula l;
  protected final Formula r;
  protected final String sign;

  protected doubleFormulaA(Formula l, Formula r, String sign) {
    this.l = l;
    this.r = r;
    this.sign = sign;
  }

  public String represent() {
    return "(" + l.represent() + " " + sign + " " + r.represent() + ")";
  }

  public Set<String> getVars() {
    var set = l.getVars();
    set.addAll(r.getVars());
    return set;
  }
}
