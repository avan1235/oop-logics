package pl.edu.mimuw.logic.formulas.single;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class varFormula implements Formula {
  private final String name;

  public varFormula(String name) {
    this.name = name;
  }

  public boolean eval(Valuation valuation) {
    return valuation.GetValue(name);
  }

  public String represent() {
    return "[" + name + "]";
  }

  public Set<String> getVars() {
    var set = new HashSet<String>();
    set.add(name);
    return set;
  }
}
