package pl.edu.mimuw.logic;

import java.util.Hashtable;

public class Valuation {
  private final Hashtable<String, Boolean> valuations;

  public Valuation() {
    this.valuations = new Hashtable<>();
  }

  public void add(String name, boolean value) {
    this.valuations.put(name, value);
  }

  public void remove(String name) {
    this.valuations.remove(name);
  }

  public boolean get(Variable variable) {
    return valuations.getOrDefault(variable.getName(), false);
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();

    this.valuations.forEach((str, val) ->
      res.append(str).append("->").append(val).append(" ")
    );

    return res.toString();
  }
}
