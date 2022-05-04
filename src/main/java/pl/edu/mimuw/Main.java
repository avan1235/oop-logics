package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.FormulaFactory;
import pl.edu.mimuw.logic.FormulaVariable;

public class Main {

  public static void main(String[] args) {
    Formula a = FormulaFactory.var("a");
    Formula b = FormulaFactory.var("b");
    Formula c = FormulaFactory.var("c");
    Formula d = FormulaFactory.var("d");
    Formula e = FormulaFactory.var("e");

    Formula formula = FormulaFactory.and(a, FormulaFactory.iff(b, FormulaFactory.implies(c, FormulaFactory.or(d, FormulaFactory.not(e)))));
    System.out.println(formula.toString());

    formula = FormulaFactory.implies(a, b);
    System.out.println(formula.toString());
  }
}
