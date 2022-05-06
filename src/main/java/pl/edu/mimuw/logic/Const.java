package pl.edu.mimuw.logic;

import java.util.Collections;
import java.util.Set;

public class Const implements Formula {
  private final boolean value;

  public Const(boolean value) {
    this.value = value;
  }

  public boolean eval(Valuation v) {
    return this.value;
  }

  public Set<Variable> getAllVariables() {
    return Collections.emptySet();
  }

  @Override
  public String toString() {
    if (this.value) return "true";
    else return "false";
  }
}
