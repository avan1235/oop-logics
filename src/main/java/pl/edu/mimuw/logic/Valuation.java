package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {
  Map<String, Boolean> values;
  public Valuation(Map<String, Boolean> values){
    this.values = new HashMap<>(values);
  }
  public boolean getValue(String var){
    return values.containsKey(var) && values.get(var);
  }

  @Override
  public String toString(){
    StringBuilder res = new StringBuilder("{ ");
    for(var variable : values.keySet()){
      res.append(variable);
      res.append(" = ");
      res.append(values.get(variable) ? "true" : "false");
      res.append(", ");
    }
    res.append("}");
    return res.toString();
  }
}
