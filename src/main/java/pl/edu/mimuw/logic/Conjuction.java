package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public class Conjuction extends Constructor implements Formula {
  public Conjuction(Formula f1, Formula f2) {
    super(f1, f2);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return f1.eval(valuation) && f2.eval(valuation);
  }

  @Override
  public Set<Variable> getVariables() {
    HashSet<Variable> variables = new HashSet<>(f1.getVariables());
    variables.addAll(f2.getVariables());
    return variables;
  }

  @Override
  public String toString() {
    return "(" + f1 + "∧" + f2 + ")";
  }
}
