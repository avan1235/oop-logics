package pl.edu.mimuw.logic;

public class Or extends MultiArgFormula implements Formula {
  public Or(Formula arg1, Formula arg2) {
    super(arg1, arg2);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return this.arg1.eval(valuation) || this.arg2.eval(valuation);
  }

  @Override
  public String toString() {
    return super.getStringRepresentation("v");
  }
}
