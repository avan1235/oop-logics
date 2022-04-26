package pl.edu.mimuw.logic;

public class Or extends Formula2Arg {
  public Or(Formula f1, Formula f2) {
    super(f1, f2);
  }
  @Override
  public boolean eval(Valuation valuation) {
    return this.f1.eval(valuation) || this.f2.eval(valuation);
  }

  @Override
  public String toString() {
    return "(" + this.f1.toString() + ") || (" + this.f2.toString() + ")";
  }
}
