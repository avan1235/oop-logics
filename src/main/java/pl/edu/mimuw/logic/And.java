package pl.edu.mimuw.logic;

public class And extends Formula2Arg {
  public And(Formula formula1, Formula formula2) {
    super(formula1, formula2);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return formula1.eval(valuation) && formula2.eval(valuation);
  }

  @Override
  public String toString() {
    return super.toString("&&");
  }
}
