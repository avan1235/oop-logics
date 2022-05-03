package pl.edu.mimuw.logic;

import java.util.HashMap;

public class Valuation {
  private final HashMap<String, Boolean> valuations;

  public Valuation() {
    this.valuations = new HashMap<>();
  }

  public void add(String var, boolean value) {
    this.valuations.put(var, value);
  }

  public boolean get(String var) {
    return valuations.getOrDefault(var, false);
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();

    this.valuations.forEach((var, val) ->
      res.append(var).append("->").append(val).append(" ")
    );

    return res.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Valuation)) return false;
    var t = (Valuation) o;
    return this.valuations.equals(t.valuations);
  }

  @Override
  public int hashCode() {
    return this.valuations.hashCode();
  }
}
