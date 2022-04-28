package pl.edu.mimuw.logic;

public class Or extends Operator2Arg {

  public Or(String name, Formula left, Formula right) {
    super(name, left, right);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return left.eval(valuation) || right.eval(valuation);
  }

  @Override
  public Formula simplify() {
    if (simpleLeft.isConstant()) {
      if (simpleLeft.eval(null)) {
        return FormulaFactory.t();
      }
      else {
        return simpleRight;
      }
    }
    else if (simpleRight.isConstant()) {
      if (simpleRight.eval(null)) {
        return FormulaFactory.t();
      }
      else {
        return simpleLeft;
      }
    }
    else {
      return FormulaFactory.or(simpleLeft, simpleRight);
    }
  }
}
