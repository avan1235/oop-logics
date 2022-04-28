package pl.edu.mimuw.logic.formulas.single;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class tFormula implements Formula {

  public tFormula() {
  }

  public boolean eval(Valuation valuation) {
    return true;
  }

  public String represent() {
    return "true";
  }

  public Set<String> getVars() {
    return new HashSet<>() {
    };
  }
}
