package pl.edu.mimuw.logic;
import java.util.Set;
import java.util.HashSet;


public interface Formula {
  boolean eval(Valuation valuation);
  String toString();
  HashSet<Variable> getVariables();
  // TODO: extend interface with needed methods
}
