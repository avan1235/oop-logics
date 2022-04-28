package pl.edu.mimuw.logic;

public class And extends Operator2Arg {

  public And(String name, Formula left, Formula right) {
    super(name, left, right);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return left.eval(valuation) && right.eval(valuation);
  }

  @Override
  public Formula simplify() {

    if (simpleLeft.isConstant()) {
      if (simpleLeft.eval(null)) {
        return simpleRight;
      }
      else {
        return FormulaFactory.f();
      }
    }
    else if (simpleRight.isConstant()) {
      if (simpleRight.eval(null)) {
        return simpleLeft;
      }
      else {
        return FormulaFactory.f();
      }
    }
    else {
      return FormulaFactory.and(simpleLeft, simpleRight);
    }
  }
}
