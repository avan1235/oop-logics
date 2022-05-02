package pl.edu.mimuw.logic;

public abstract class OneArgumentFormula implements Formula {

  protected String name;

  public abstract boolean eval(Valuation valuation);

  public String toString() {
    return name;
  }
}
