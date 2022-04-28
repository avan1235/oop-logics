package pl.edu.mimuw.logic;

import java.util.List;
import java.util.Set;

public interface Formula {

  String represent();

  boolean eval(Valuation valuation);

  Set<String> getVars();
}
