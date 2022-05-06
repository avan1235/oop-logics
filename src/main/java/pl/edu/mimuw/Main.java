package pl.edu.mimuw;

import static pl.edu.mimuw.logic.FormulaFactory.*;

public class Main {

  public static void main(String[] args) {
    final var P = var("p");
    final var Q = var("q");

    System.out.println("Logical expressions:");
    System.out.println("\t Conjunction: " + and(P, Q));
    System.out.println("\t Disjunction: " + or(P, Q));
    System.out.println("\t Implication: " + implies(P, Q));
    System.out.println("\t If and only if: " + iff(P, Q));
    System.out.println("\t Negation: " + not(P));
    System.out.println("\t Constants: " + t() + ", " + f());
  }
}
