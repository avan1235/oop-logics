package pl.edu.mimuw;

import pl.edu.mimuw.logic.Constant;
import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.FormulaFactory;

public class Main {

  public static void main(String[] args) {
    var and = FormulaFactory.and(FormulaFactory.t(), FormulaFactory.var("y"));
    var simpleAnd = and.simplify();

    System.out.println(and);
    System.out.println(simpleAnd);

    var or  = FormulaFactory.or(FormulaFactory.f(), FormulaFactory.var("x"));
    var simpleOr = or.simplify();

    System.out.println(or);
    System.out.println(simpleOr);

    var andImpliesOr = FormulaFactory.implies(and, or);
    var simpleAndImpliesOr = andImpliesOr.simplify();

    System.out.println(andImpliesOr);
    System.out.println(simpleAndImpliesOr);
  }
}
