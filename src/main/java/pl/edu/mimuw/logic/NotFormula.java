package pl.edu.mimuw.logic;

public class NotFormula extends Formula1Arg {
  public NotFormula(Formula f1) {
    super(f1);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return !formula.eval(valuation);
  }

  @Override
  public String toString(){
    return "~("+formula.toString()+")";
  }
}
