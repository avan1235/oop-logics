package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public class Variable implements Formula {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public boolean eval(Valuation valuation) {
    return valuation.get(this.name);
  }

  public String toString() {
    return "<" + this.name + ">";
  }

  public Set<String> getAllVariables() {
    Set<String> s = new HashSet<>();
    s.add(this.name);

    return s;
  }
}
