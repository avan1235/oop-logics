package pl.edu.mimuw;

import pl.edu.mimuw.logic.FormulaFactory;
import pl.edu.mimuw.logic.Solver;

public class Main {

  public static void main(String[] args) {
    var p = FormulaFactory.var("p");
    var q = FormulaFactory.var("q");
    var r = FormulaFactory.var("r");
    var no = FormulaFactory.f();
    var s = FormulaFactory.var("s");
    var two = FormulaFactory.and(p, q);
    var two2 = FormulaFactory.or(r, no);
    var two3 = FormulaFactory.iff(s, p);
    var two4 = FormulaFactory.iff(two3, FormulaFactory.t());
    var all = FormulaFactory.implies(two, two2);
    var all2 = FormulaFactory.or(all, two4);
    System.out.println(all2);
    System.out.println(all2.allVariables());
    System.out.println(Solver.solve(all2));
  }
}
