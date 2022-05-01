package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Valuation {
  private final Map<Variable, Boolean> values;

  public Valuation(Map<Variable, Boolean> values) {
    this.values = values;
  }

  public Valuation() {
    this(new HashMap<>());
  }

  public boolean getValue(Variable v) {
    return this.values.get(v);
  }

  public List<Variable> getAllVariables() {
    return this.values.keySet().stream().map(Variable::new).collect(Collectors.toList());
  }

  public void setValueOnIndex(int id, boolean value) {
    int i = 0;

    for (Variable v : this.values.keySet()) {
      if (i == id) {
        this.values.put(v, value);
        return;
      }
      i++;
    }
  }

  public void add(Variable v, boolean value) {
    this.values.put(new Variable(v), value);
  }

  public int size() {
    return this.values.size();
  }

  @Override
  public String toString() {
    final var sb = new StringBuilder();
    int i = 0;

    sb.append("{");
    for (Variable v : this.values.keySet()) {
      sb.append(v.getName()).append("=").append(this.values.get(v));

      if (i != this.values.size() - 1) {
        sb.append(", ");
      }
      i++;
    }
    sb.append("}");

    return sb.toString();
  }
}
