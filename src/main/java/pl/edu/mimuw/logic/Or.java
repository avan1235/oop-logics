package pl.edu.mimuw.logic;

public class Or extends TwoArgumentsFormula{

  public Or(Formula left, Formula right) {
    super(left, right, "||");
  }

  @Override
  public boolean eval(Valuation valuation) {
    return this.left.eval(valuation) || this.right.eval(valuation);
  }
}
