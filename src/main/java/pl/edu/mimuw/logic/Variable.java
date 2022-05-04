package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Variable implements Formula {

  String varName;

  public Variable(String varName) {
    this.varName = varName;
  }
  public Variable(Variable var) {
    this(var.getVarName());
  }

  public String getVarName() {
    return varName;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return valuation.getValue(this);
  }

  public Formula simplify() {
    return this;
  }

  @Override
  public Set<Variable> findVariables() {
    var set = new HashSet<Variable>();
    set.add(this);
    return set;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Variable variable = (Variable) o;
    return Objects.equals(varName, variable.varName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(varName);
  }

  public String toString() {
    return varName;
  }
}
