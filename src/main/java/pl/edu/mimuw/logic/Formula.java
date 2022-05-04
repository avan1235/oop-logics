package pl.edu.mimuw.logic;

import java.util.Set;

public interface Formula {
  boolean eval(Valuation valuation);
  String toString();
  Set<String> getDependencies();
}
