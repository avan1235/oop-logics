package pl.edu.mimuw.logic;

public class Not extends Formula1Arg {

  public Not(Formula formula) {
    super(formula);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return !this.formula.eval(valuation);
  }

  @Override
  public String toString() {
    return super.toString("!");
  }
}
