package pl.edu.mimuw.logic;

import java.util.*;

public class Variable implements Formula {
  private String name;
  private boolean value;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public boolean eval(Valuation valuation) {
    Boolean helper1 = valuation.getValueOfVar(this.name);
    if (helper1 == null)
      return true;
    return helper1;
  }

  public String toString() {
    return this.name;
  }

  public Set<String> variables() {
    var set1 = new HashSet<String>();
    set1.add(this.toString());
    return set1;
  }
}
