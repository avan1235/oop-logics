package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

import java.util.ArrayList;
import java.util.List;

public class Solver {
  private static List<Integer> intToBits(int x, int numberOfBits) {
    List<Integer> l = new ArrayList<>();

    for(int i = 0; i < numberOfBits; i++) {
      l.add(x % 2);
      x /= 2;
    }

    return l;
  }


  public static Valuation solve(Formula f) {
    List<String> variables = new ArrayList<>(f.getAllVariables());

    int n = variables.size();

    if(n == 0) {
      return new Valuation();
    }

    for (int i = 0; i < (1 << n); i++) {
      List<Integer> l = intToBits(i, n);

      Valuation val = new Valuation();
      for(int j = 0; j < n; j++) {
        val.add(variables.get(j), (l.get(j) == 1));
      }

      if(f.eval(val)) {
        return val;
      }
    }

    return null;
  }
}
