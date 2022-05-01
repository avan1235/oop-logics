package pl.edu.mimuw.logic;

public class Iff extends Operator2Args {
  public Iff(Formula f1, Formula f2) {
    super(f1, f2);
  }

  public boolean eval(Valuation valuation) {
    return this.getLeftValue(valuation) == this.getRightValue(valuation);
  }

  @Override
  public String toString() {
    return "(" + this.left.toString() + " <=> " + this.right.toString() + ")";
  }
}
