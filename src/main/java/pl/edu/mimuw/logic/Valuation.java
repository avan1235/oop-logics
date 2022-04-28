package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {
  final Map<Variable, Boolean> values;

  public Valuation() {
    this.values = new HashMap<>();
  }

  public Valuation addValue(Variable variable, boolean value) {
    values.put(variable, value);
    return this;
  }

  public boolean getValue(Variable key) {
    return values.get(key);
  }
}
