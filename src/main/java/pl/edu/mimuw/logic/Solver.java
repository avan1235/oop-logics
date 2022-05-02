package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solver {

  private Solver() {}

  public static Valuation solve(Formula formula) {
    Set<String> set = formula.allVariables();
    String[] empty = new String[0];
    String[] arr = set.toArray(empty);
    int size = arr.length;
    if (size == 0) {
      return null;
    }
    boolean[] keys = new boolean[size];
    Map<String, Boolean> map = new HashMap<String, Boolean>();
    for (int i = 0; i < (1 << size); i++) {
      int l = i;
      for (int j = 0; j < size; j++) {
        keys[j] = ((l % 2) == 0);
        l = l / 2;
        map.put(arr[j], keys[j]);
      }
      var currentValuation = new Valuation(map);
      if (formula.eval(currentValuation)) {
        return currentValuation;
      } else {
        map.clear();
      }
    }
    return null;
  }
}
