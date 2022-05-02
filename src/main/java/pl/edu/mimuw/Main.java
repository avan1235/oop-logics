package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.FormulaFactory;
import pl.edu.mimuw.logic.Valuation;

public class Main {

  public static void main(String[] args) {
    Formula p = FormulaFactory.var("p");
    Formula q = FormulaFactory.var("q");
    Formula pAndQ = FormulaFactory.and(p, q);
    System.out.println(pAndQ);
    Formula r = FormulaFactory.var("r");
    Formula pqImpliesR = FormulaFactory.implies(pAndQ, r);
    System.out.println(pqImpliesR);

    Valuation pqr1 = new Valuation();
    pqr1.add("p", true);
    pqr1.add("q", true);

    pqr1.add("r", false);
    System.out.println(pqr1);
    pqr1.add("r", true);
    System.out.println(pqr1);

    System.out.println("Formula " + pqImpliesR + " is " + pqImpliesR.eval(pqr1) + " for " + pqr1);
    pqr1.add("p", false);
    System.out.println("Formula " + pqImpliesR + " is " + pqImpliesR.eval(pqr1) + " for " + pqr1);
  }
}
