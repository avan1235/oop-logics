package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {

  Map<String, Boolean> map;

  public Valuation(Map<String, Boolean> map) {
    this.map = map;
  }

  public Map<String, Boolean> getMap() {
    Map<String, Boolean> nowa = new HashMap<String, Boolean>();
    nowa.putAll(map);
    return nowa;
  }

  public boolean get(String name) {
    return map.get(name);
  }

  @Override
  public String toString() {
    return map.toString();
  }
}
