package pl.edu.mimuw.logic.formulas.single;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class fFormula implements Formula {

  public fFormula() {}

  public boolean eval(Valuation valuation) {
    return false;
  }

  public String represent(){
    return "false";
  }

  public Set<String> getVars() {
    return new HashSet<>() {
    };
  }
}
