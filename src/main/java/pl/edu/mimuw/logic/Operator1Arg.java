package pl.edu.mimuw.logic;

import java.util.Set;

public abstract class Operator1Arg implements Formula {
  protected final Formula arg;

  protected Operator1Arg(Formula arg) {
    this.arg = arg;
  }

  public Set<Variable> getAllVariables() {
    return this.arg.getAllVariables();
  }

  protected boolean getArgValue(Valuation valuation) {
    return this.arg.eval(valuation);
  }
}
