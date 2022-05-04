package pl.edu.mimuw.logic;

import java.util.ArrayList;

public class FormulaConstant implements Formula {

  private final boolean value;

  public FormulaConstant(boolean value) {
    this.value = value;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return this.value;
  }

  @Override
  public String toString() {
    if (this.value) return "1";
    return "0";
  }

  public ArrayList<FormulaVariable> variables() {
    return new ArrayList<>();
  }
}

