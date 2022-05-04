package pl.edu.mimuw.logic;

public class Neg extends OneArgFormula{

  public Neg(Formula a) {
    super(a);
  }

  public boolean eval(Valuation valuation) {
    return ! f.eval(valuation);
  }

  public String toString() {
    return "~" + f.toString();
  }
}
