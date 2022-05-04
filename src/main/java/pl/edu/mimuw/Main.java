package pl.edu.mimuw;

import pl.edu.mimuw.logic.*;

public class Main {

  public static void main(String[] args) {
    Formula formula=new Equivalence(new Conjunction(new Var("x"),new Const(true)),new Alternative(new Negation(new Var("y")),new Implication(new Const(false),new Var("z"))));
    Solver solver=new Solver(formula);
    Valuation valuation=solver.getTrueValuation(0);
    System.out.println(solver.toString());
    System.out.println(valuation.toString());
  }
}
