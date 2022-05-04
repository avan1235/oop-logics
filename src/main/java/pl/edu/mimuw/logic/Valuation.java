package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {
  private final Map<String, Boolean> map;

  public Valuation() {
    this.map = new HashMap<>();
  }

  public boolean get(String name) {
    return map.get(name);
  }

  public void add(String name, boolean value) {
    map.put(name, value);
  }

  public String toString() {
    final var sb = new StringBuilder();
    sb.append("Evaluation of ")
      .append(map.size())
      .append(" variables:\n");

    for(var entry : map.entrySet()) {
      sb.append(entry.getKey())
        .append(" as ");
      if (entry.getValue()) {
        sb.append("true\n");
      } else {
        sb.append("false\n");
      }
    }

    return sb.toString();
  }
}
