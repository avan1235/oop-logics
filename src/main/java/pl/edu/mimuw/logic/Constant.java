package pl.edu.mimuw.logic;

import java.util.Set;

public class Constant implements Formula {
  final boolean value;

  public Constant(boolean value) {
    this.value = value;
  }

  public boolean eval(Valuation valuation) {
    return value;
  }

  public boolean isConstant() {
    return true;
  }

  public Set<Variable> findVariables() {
    return null;
  }

  public String toString() {
    return value ? "T" : "F";
  }
}
