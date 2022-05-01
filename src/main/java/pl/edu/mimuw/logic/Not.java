package pl.edu.mimuw.logic;

public class Not extends Operator1Arg {
  public Not(Formula arg) {
    super(arg);
  }

  public boolean eval(Valuation valuation) {
    return !this.getArgValue(valuation);
  }

  @Override
  public String toString() {
    return "-(" + this.arg.toString() + ")";
  }
}
