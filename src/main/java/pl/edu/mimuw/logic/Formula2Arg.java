package pl.edu.mimuw.logic;


import java.util.ArrayList;

public abstract class Formula2Arg implements Formula {
  protected Formula formula1;
  protected Formula formula2;

  public Formula2Arg(Formula formula1, Formula formula2) {
    this.formula1 = formula1;
    this.formula2 = formula2;
  }

  public String toString(String symb) {
    return "(" + this.formula1.toString() + " " + symb + " " + this.formula2.toString() + ")";
  }

  public ArrayList<FormulaVariable> variables() {
    ArrayList<FormulaVariable> tmp = new ArrayList<>();
    tmp.addAll(this.formula1.variables());
    tmp.addAll(this.formula2.variables());
    return tmp;
  }

}
