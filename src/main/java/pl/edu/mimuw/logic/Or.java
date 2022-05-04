package pl.edu.mimuw.logic;

public class Or extends TwoArgFormula{

  public Or(Formula a, Formula b) {
    super(a, b);
  }

  public boolean eval(Valuation valuation) {
    return f1.eval(valuation) || f2.eval(valuation);
  }

  public String toString(){
    return "( " + f1.toString() + " | " + f2.toString() + " )";
  }
}
