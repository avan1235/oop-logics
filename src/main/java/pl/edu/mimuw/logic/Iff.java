package pl.edu.mimuw.logic;

public class Iff extends Formula2Arg {

  public Iff(Formula f1, Formula f2) {
    super(f1, f2);
  }
  @Override
  public boolean eval(Valuation valuation) {
    boolean sentence1 = this.f1.eval(valuation);
    boolean sentence2 = f2.eval(valuation);
    if (sentence1 == sentence2)
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "(" + this.f1.toString() + ") <=> (" + this.f2.toString() + ")";
  }
}
