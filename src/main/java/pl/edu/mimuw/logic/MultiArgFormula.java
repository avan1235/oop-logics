package pl.edu.mimuw.logic;

import java.util.Set;

public abstract class MultiArgFormula {
  protected final Formula arg1, arg2;

  protected MultiArgFormula(Formula arg1, Formula arg2) {
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

  protected String getStringRepresentation(String middleElement) {
    return "(" + this.arg1.toString() + " " + middleElement + " " + this.arg2.toString() + ")";
  }

  public Set<String> getAllVariables() {
    Set<String> s1 = this.arg1.getAllVariables();
    s1.addAll(this.arg2.getAllVariables());

    return s1;
  }
}
