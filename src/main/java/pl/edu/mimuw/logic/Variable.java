package pl.edu.mimuw.logic;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Variable implements Formula {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public Variable(Variable var) {
    this(var.name);
  }

  public boolean eval(Valuation valuation) {
    return valuation.getValue(this);
  }

  public Set<Variable> getAllVariables() {
    return Collections.singleton(new Variable(this));
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Variable)) return false;
    Variable v = (Variable) o;
    return this.name.equals(v.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }

  @Override
  public String toString() {
    return this.name;
  }
}
