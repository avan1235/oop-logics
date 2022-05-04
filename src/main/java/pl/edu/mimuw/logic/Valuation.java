package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.List;

public class Valuation {

  HashMap<String, Boolean> variableMap;

  public HashMap<String, Boolean> getVariableMap() {
    return variableMap;
  }

  public Valuation(List<String> keys, List<Boolean> values) {
    this.variableMap = new HashMap<>();
    for(int i = 0; i < keys.size(); i++) {
      variableMap.put(keys.get(i), values.get(i));
    }
  }

  @Override
  public String toString() {
    var sb=new StringBuilder();
    sb.append("Valuation according to HashMap: ").append(this.variableMap.toString());
    return sb.toString();
  }
}
