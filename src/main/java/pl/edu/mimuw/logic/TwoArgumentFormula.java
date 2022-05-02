package pl.edu.mimuw.logic;

import java.util.Set;

public abstract class TwoArgumentFormula implements Formula {

  protected Formula x1;
  protected Formula x2;
  protected String name;

  protected TwoArgumentFormula(Formula x1, Formula x2) {
    this.x1 = x1;
    this.x2 = x2;
  }

  @Override
  public abstract boolean eval(Valuation valuation);

  @Override
  public String toString() {
    return "(" + x1.toString() + " " + name + " " + x2.toString() + ")";
  }

  @Override
  public Set<String> allVariables() {
    Set<String> s1 = x1.allVariables();
    Set<String> s2 = x2.allVariables();
    s1.addAll(s2);
    return s1;
  }
}
