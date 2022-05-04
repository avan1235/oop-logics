package pl.edu.mimuw.logic;

import java.util.Set;

public class Not implements Formula {
  private final Formula arg;

  public Not(Formula arg) {
    this.arg = arg;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return !this.arg.eval(valuation);
  }

  @Override
  public String toString() {
    return "(~" + this.arg.toString() + ")";
  }

  public Set<String> getAllVariables() {
    return this.arg.getAllVariables();
  }
}
