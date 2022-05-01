package pl.edu.mimuw;

import pl.edu.mimuw.logic.FormulaFactory;

public class Main {

  public static void main(String[] args) {
    final var P = FormulaFactory.var("p");
    final var Q = FormulaFactory.var("q");

    System.out.println("Logical expressions:");
    System.out.println("\t Conjunction: " + FormulaFactory.and(P, Q));
    System.out.println("\t Disjunction: " + FormulaFactory.or(P, Q));
    System.out.println("\t Implication: " + FormulaFactory.implies(P, Q));
    System.out.println("\t If and only if: " + FormulaFactory.iff(P, Q));
    System.out.println("\t Negation: " + FormulaFactory.not(P));
    System.out.println("\t Constants: " + FormulaFactory.t() + ", " + FormulaFactory.f());
  }
}
