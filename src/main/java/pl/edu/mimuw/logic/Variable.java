package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

  public List<Variable> getAllVariables() {
    return new ArrayList<>(List.of(new Variable(this)));
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
