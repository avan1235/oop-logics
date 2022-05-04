package pl.edu.mimuw.logic;

import java.util.ArrayList;

public abstract class Formula1Arg implements Formula {
  protected Formula formula;

  public Formula1Arg(Formula formula) {
    this.formula = formula;
  }

  public String toString(String symb) {
    return symb + this.formula.toString();
  }

  public ArrayList<FormulaVariable> variables() {
    ArrayList<FormulaVariable> tmp = new ArrayList<>();
    tmp.addAll(this.formula.variables());
    return tmp;
  }
}
