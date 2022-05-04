package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.Set;

public class Solver {
  private final Valuation currentValuation;
  private Valuation finalValuation = null;
  private final Variable[] variables;
  private final Formula simpleFormula;

  public Solver(Formula f) {
    simpleFormula = f.simplify();
    currentValuation = new Valuation();
    var variables = simpleFormula.findVariables();
    if (variables != null) {
      this.variables = simpleFormula.findVariables().toArray(Variable[]::new);
    }
    else {
      this.variables = new Variable[]{};
    }
  }

  private boolean checkValuation() {
    return simpleFormula.eval(currentValuation);
  }

  private void setValuation(int index) {
    if (index >= variables.length) {
      if (checkValuation()) {
        finalValuation = new Valuation(currentValuation);
      }
    }
    else {
      currentValuation.addValue(variables[index], true);
      setValuation(index + 1);
      currentValuation.addValue(variables[index], false);
      setValuation(index + 1);
    }
  }

  public Valuation solve() {
    setValuation(0);
    return new Valuation(finalValuation);
  }
}
