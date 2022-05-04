package pl.edu.mimuw.logic;

import java.util.HashMap;

public class Valuation {
  private HashMap<String, Boolean> values;

  public Valuation(HashMap<String, Boolean> values) {
    this.values = new HashMap<String, Boolean>(values);

  }

  public Boolean getValueOfVar(String name) {
    if (this.values.get(name) != null) {
      return this.values.get(name);
    } else
      return true;
  }

  public String toString() {
    var sb = new StringBuilder();
    this.values.forEach((key, value) -> {
      sb.append(key).append(" ").append(value.toString()).append(", ");
    });
    return sb.toString();
  }

}
