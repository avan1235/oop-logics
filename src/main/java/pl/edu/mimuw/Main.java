package pl.edu.mimuw;

import pl.edu.mimuw.logic.*;

import static pl.edu.mimuw.logic.FormulaFactory.*;

public class Main {

  private static void printSolved(Formula formula) {
    Valuation found = Solver.solveBrutally(formula);
    String res;
    if (found != null) res = found.toString();
    else res = "all valuations";

    System.out.println("Formula " + formula + " is " + formula.eval(found) + " for " + res);
  }

  public static void main(String[] args) {
    Formula p = var("p");
    Formula q = var("q");
    Formula r = var("r");
    Formula pAndQ = and(p, q);

    Formula pqImpliesR = implies(pAndQ, r);
    printSolved(pqImpliesR);

    Formula pqImpliesR2 = and(pqImpliesR, r);
    printSolved(pqImpliesR2);

    Formula never = and(t(), f());
    printSolved(never);
  }
}
