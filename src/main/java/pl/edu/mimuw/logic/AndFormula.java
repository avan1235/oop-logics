package pl.edu.mimuw.logic;

public class AndFormula extends Formula2Arg {
  public AndFormula(Formula f1, Formula f2) {
    super(f1, f2);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return formula1.eval(valuation) && formula2.eval(valuation);
  }

  @Override
  public String toString(){
    return "("+formula1.toString() + " ^ " + formula2.toString()+")";
  }
}
