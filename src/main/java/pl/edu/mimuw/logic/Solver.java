package pl.edu.mimuw.logic;

import java.util.List;

public class Solver {
  public Solver() {
  }

  public static Valuation solve(Formula formula) {
    final List<String> variables = (List<String>) formula.getVariables();
    int size = variables.size();

    for (int i = 0; i < (1 << size); i++) {
      Valuation check = new Valuation();

      for (int j = 0; j < size; j++) {
        check.setValue(variables.get(j), ((i<<j) & 1)==1);
      }

      if (formula.eval(check)) return check;
    }

    return null;
  }
}
