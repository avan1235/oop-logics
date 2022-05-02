package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public class Variable extends OneArgumentFormula {

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public Set<String> allVariables() {
    var s1 = new HashSet<String>();
    s1.add(name);
    return s1;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return valuation.get(name);
  }
}
