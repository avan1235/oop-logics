package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {
  private final Map<FormulaVariable, Boolean> values;

  public Valuation(Map<FormulaVariable, Boolean> values) {
    this.values = new HashMap<>(values);
  }

  public Boolean getValue(FormulaVariable x) {
    return this.values.get(x);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (var v : this.values.keySet()) {
      sb.append(v.toString()).append(": ");
      if (this.values.get(v)) sb.append("true\n");
      else sb.append("false\n");
    }
    return sb.toString();
  }
}
