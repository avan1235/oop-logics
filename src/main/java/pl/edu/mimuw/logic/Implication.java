package pl.edu.mimuw.logic;

import java.util.ArrayList;

public class Implication extends DoubleArg {
  public Implication(Formula left, Formula right) {
    super(left, right);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return !this.left.eval(valuation) || (this.left.eval(valuation) && this.right.eval(valuation));
  }

  @Override
  public String toString() {
    var sb=new StringBuilder();
    sb.append("Implication with children:\n").append("left: ").append(this.left.toString()).append("\nright: ").append(this.right.toString());
    return sb.toString();
  }
}
