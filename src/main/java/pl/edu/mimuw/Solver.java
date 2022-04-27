package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

import java.util.*;

public class Solver {
  private Solver() {}
  public static Valuation solve(Formula formula) throws Exception {
    Set<String> vars = formula.collectVariables();
    for(int i = 0; i < Math.pow(2, vars.size()); i++){
      Map<String, Boolean> map = new HashMap<>();
      int bitmask = i;
      for(var variable : vars){
        map.put(variable, (bitmask & 1) == 1);
        bitmask /= 2;
      }
      Valuation valuation = new Valuation(map);
      if (formula.eval(valuation)) return valuation;
    }
    throw new Exception("Solution not found");
  }
}
