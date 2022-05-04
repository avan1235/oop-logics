package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {
  private final Map<Variable, Boolean> values;

  public Valuation() {
    this.values = new HashMap<>();
  }

  public Valuation(Valuation valuation) {
    if (valuation != null) {
      values = Map.copyOf(valuation.getValues());
    }
    else {
      values = new HashMap<>();
    }
  }

  public Valuation addValue(Variable variable, boolean value) {
    values.put(variable, value);
    return this;
  }

  public boolean getValue(Variable key) {
    return values.get(key);
  }

  public Map<Variable, Boolean> getValues() {
    return values;
  }
}
