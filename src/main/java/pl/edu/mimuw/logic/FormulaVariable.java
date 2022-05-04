package pl.edu.mimuw.logic;

import java.util.ArrayList;

public class FormulaVariable implements Formula {
  private final String name;

  public FormulaVariable(String name) {
    this.name = name;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return valuation.getValue(this);
  }

  @Override
  public String toString() {
    return this.name;
  }

  public ArrayList<FormulaVariable> variables() {
    ArrayList<FormulaVariable> tmp = new ArrayList<>();
    tmp.add(this);
    return tmp;
  }
}
