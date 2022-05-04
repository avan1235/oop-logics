package pl.edu.mimuw.logic;

public class Not extends Operator1Arg {

  public Not(String name, Formula child) {
    super(name, child);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return !child.eval(valuation);
  }

  @Override
  public Formula simplify() {
    if (simpleChild.isConstant()) {
      if (simpleChild.eval(null)) {
        return FormulaFactory.f();
      }
      else {
        return FormulaFactory.t();
      }
    }
    else {
      return FormulaFactory.not(simpleChild);
    }
  }
}
