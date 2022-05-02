package pl.edu.mimuw.logic;

public class Negation extends Constructor {
  public Negation(Formula f1) {
    super(f1, null);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return !f1.eval(valuation);
  }

  @Override
  public String toString() {
    return "¬" + f1;
  }
}
