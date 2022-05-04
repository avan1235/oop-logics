package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public class Constant implements Formula {
  private final boolean value;

  public Constant(boolean value) {
    this.value = value;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return value;
  }

  @Override
  public String toString() {
    return value ? "true" : "false";
  }

  public Set<String> getAllVariables() {
    return new HashSet<>();
  }
}
