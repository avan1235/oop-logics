package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {
  private final Map<String, Boolean> variables;

  public Valuation() {
    variables = new HashMap<>();
  }

  public void SetValue(String varName, boolean value) {
    variables.put(varName, value);
  }

  public boolean GetValue(String varName) {
    Boolean val = variables.get(varName);
    if (val == null) return false;
    return val;
  }
}
