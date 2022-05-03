package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.FormulaFactory;
import pl.edu.mimuw.logic.Solver;
import pl.edu.mimuw.logic.Valuation;

public class Main {

  private static void printSolved(Formula formula) {
    Valuation found = Solver.solveBrutally(formula);
    String res;
    if (found != null) res = found.toString();
    else res = "all valuations";

    System.out.println("Formula " + formula + " is " + formula.eval(found) + " for " + res);
  }

  public static void main(String[] args) {
    Formula p = FormulaFactory.var("p");
    Formula q = FormulaFactory.var("q");
    Formula r = FormulaFactory.var("r");
    Formula pAndQ = FormulaFactory.and(p, q);

    Formula pqImpliesR = FormulaFactory.implies(pAndQ, r);
    printSolved(pqImpliesR);

    Formula pqImpliesR2 = FormulaFactory.and(pqImpliesR, r);
    printSolved(pqImpliesR2);

    Formula never = FormulaFactory.and(FormulaFactory.t(), FormulaFactory.f());
    printSolved(never);
  }
}
