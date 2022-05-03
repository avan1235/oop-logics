package pl.edu.mimuw.logic;

import java.util.Set;

public class Constant implements Formula {
  private final boolean value;

  public Constant(boolean value) {
    this.value = value;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return this.value;
  }

  @Override
  public Set<Variable> getVariables() {
    return null;
  }

  @Override
  public String toString() {
    return this.value ? "⊤" : "⊥";
  }
}
