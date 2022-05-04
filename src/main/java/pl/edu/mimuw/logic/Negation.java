package pl.edu.mimuw.logic;

public class Negation extends SingleArg {
  public Negation(Formula child) {
    super(child);
  }

  public boolean eval(Valuation valuation) {
    return !this.child.eval(valuation);
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    sb.append("Single argument formula with child: ").append(this.child.toString());
    return sb.toString();
  }
}
