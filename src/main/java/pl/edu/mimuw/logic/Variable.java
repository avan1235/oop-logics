package pl.edu.mimuw.logic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Variable implements Formula {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return valuation.get(this);
  }

  @Override
  public Set<Variable> getVariables() {
    return new HashSet<>(Collections.singleton(this));
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Variable)) return false;
    var t = (Variable) o;
    return this.name.equals(t.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return this.name;
  }
}
