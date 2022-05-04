package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

import static pl.edu.mimuw.logic.FormulaFactory.*;

public class Main {

  public static void main(String[] args) {
    final Formula f1 = iff(
      or(
        var("p"),
        var("q")
      ),
      and(
        not(var("r")),
        var("q")
      )
    );

    System.out.println("Formula f1: " + f1);

    final Valuation val1 = new Valuation();
    val1.add("p", false);
    val1.add("q", true);
    val1.add("r", false);

    System.out.println(val1);
    System.out.println("f1 evaluates to " + f1.eval(val1));

    final Valuation val2 = new Valuation();
    val2.add("p", true);
    val2.add("q", false);
    val2.add("r", true);

    System.out.println(val2);
    System.out.println("Now f1 evaluates to " + f1.eval(val2));

    Valuation v = Solver.solve(f1);
    System.out.println("Valuation found:");
    System.out.println(v);
  }
}
