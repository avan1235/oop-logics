package pl.edu.mimuw.logic;
 

public class And extends TwoArgumentFormula {

  public And(Formula x1, Formula x2) {
    super(x1, x2);
    name = "&&";
  }

  @Override
  public boolean eval(Valuation valuation) {
    return (x1.eval(valuation)) && (x2.eval(valuation));
  }
}
