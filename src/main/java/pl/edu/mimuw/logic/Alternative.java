package pl.edu.mimuw.logic;


public class Alternative extends DoubleArg {

  public Alternative(Formula left, Formula right) {
    super(left, right);
  }

  @Override
  public boolean eval(Valuation valuation) {
    return this.left.eval(valuation) || this.right.eval(valuation);
  }

  @Override
  public String toString() {
    var sb=new StringBuilder();
    sb.append("Alternative with children:\n").append("left: ").append(this.left.toString()).append("\nright: ").append(this.right.toString());
    return sb.toString();
  }
}
