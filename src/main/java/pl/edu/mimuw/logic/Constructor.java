package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public abstract class Constructor implements Formula {
  protected final Formula f1;
  protected final Formula f2;

  public Constructor(Formula f1, Formula f2) {
    this.f1 = f1;
    this.f2 = f2;
  }

  @Override
  public abstract boolean eval(Valuation valuation);

  @Override
  public Set<Variable> getVariables() {
    HashSet<Variable> variables = new HashSet<>();
    for (Formula f : new Formula[]{f1, f2})
      if (f != null && f.getVariables() != null) variables.addAll(f.getVariables());
    return variables;
  }

  @Override
  public abstract String toString();
}
