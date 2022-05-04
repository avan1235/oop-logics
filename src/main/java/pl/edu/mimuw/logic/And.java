package pl.edu.mimuw.logic;

public class And extends TwoArgFormula{

  public And(Formula a, Formula b) {
    super(a, b);
  }

  public boolean eval(Valuation valuation) {
    return f1.eval(valuation) && f2.eval(valuation);
  }

  public String toString(){
    return "( " + f1.toString() + " & " + f2.toString() + " )";
  }
}
