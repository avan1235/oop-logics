package pl.edu.mimuw.logic;

import java.util.Set;

public interface Formula {

  boolean eval(Valuation valuation);

  Set<Variable> findVariables();

  default Formula simplify() {
    return this;
  }

  default boolean isConstant() {
    return false;
  }


}
