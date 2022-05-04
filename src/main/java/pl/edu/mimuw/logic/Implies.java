package pl.edu.mimuw.logic;

public class Implies extends Formula2Arg {

  public Implies(Formula formula1, Formula formula2) {
    super(formula1, formula2);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return !(this.formula1.eval(valuation) && !this.formula2.eval(valuation));
  }

  @Override
  public String toString() {
    return super.toString("=>");
  }
}
