package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Const implements Formula {
  private final boolean value;

  public Const(boolean value) {
    this.value = value;
  }

  public boolean eval(Valuation v) {
    return this.value;
  }

  public List<Variable> getAllVariables() {
    return Collections.emptyList();
  }

  @Override
  public String toString() {
    if (this.value) return "true";
    else return "false";
  }
}
