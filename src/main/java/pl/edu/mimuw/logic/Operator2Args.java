package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.List;

public abstract class Operator2Args implements Formula {
  protected final Formula left;
  protected final Formula right;

  protected Operator2Args(Formula left, Formula right) {
    this.left = left;
    this.right = right;
  }

  public List<Variable> getAllVariables() {
    final var variables = new ArrayList<Variable>();

    variables.addAll(this.left.getAllVariables());
    variables.addAll(this.right.getAllVariables());

    return variables;
  }

  protected boolean getLeftValue(Valuation valuation) {
    return this.left.eval(valuation);
  }

  protected boolean getRightValue(Valuation valuation) {
    return this.right.eval(valuation);
  }
}
