package pl.edu.mimuw.logic;

import javax.xml.validation.Validator;

public class Solver {
  private String[] variables;
  private boolean[] values;

  public Solver() {
  }

  public void setVariables(String[] variables) {
    this.variables = variables;
  }

  private Valuation updateValuation() {
    var valuation = new Valuation();
    for (int i = 0; i < variables.length; i++) {
      valuation.SetValue(variables[i], values[i]);
    }
    return valuation;
  }

  private boolean tryy(Formula formula, int i) {
    if (i == variables.length) return formula.eval(updateValuation());

    if (tryy(formula, i + 1)) return true;
    values[i] = true;
    if (tryy(formula, i + 1)) return true;
    values[i] = false;
    return false;
  }

  public boolean[] solve(Formula formula) {
    variables = new String[formula.getVars().size()];
    formula.getVars().toArray(variables);
    values = new boolean[variables.length];
    for (int i = 0; i < variables.length; i++) values[i] = false;

    tryy(formula, 0);


    return values;
  }
}
