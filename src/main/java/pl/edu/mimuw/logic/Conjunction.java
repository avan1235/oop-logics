package pl.edu.mimuw.logic;

public class Conjunction extends Constructor implements Formula {
  public Conjunction(Formula f1, Formula f2) {
    super(f1, f2);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return f1.eval(valuation) && f2.eval(valuation);
  }

  @Override
  public String toString() {
    return "(" + f1 + "∧" + f2 + ")";
  }
}
