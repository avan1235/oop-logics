package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {

  private final Map<String, Boolean> vars;

  public Valuation() {
    this.vars = new HashMap<String, Boolean>();
  }

  public void setValue(String var, boolean bool) {
    this.vars.put(var, bool);
  }

  public boolean getValue(String var) {
    return this.vars.getOrDefault(var, false);
  }
}
