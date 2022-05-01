package pl.edu.mimuw.logic;

public final class Solver {

  private Solver() {
  }

  /**
   * Finds a solution to the given formula. If no solution is found, null is returned.
   *
   * @param formula Formula to be solved.
   * @return Solution found or null if no solution is found.
   */
  public static Valuation anySolve(Formula formula) {
    var v = new Valuation();
    final var variables = formula.getAllVariables();

    if (variables.size() == 0) {
      if (formula.eval(v)) {
        return v;
      } else {
        return null;
      }
    }

    for (var currVar : variables) v.add(currVar, true);

    var solution = new Valuation();

    findSolution(formula, v, 0, solution);
    if (solution.size() == 0) {
      return null;
    }
    return solution;
  }

  /**
   * Finds a solution to the given formula using recursive backtracking. If any solution is found, it is returned to the
   * given solution parameter. If no solution is found, null is returned to the solution parameter. The given valuation
   * is used as a starting point for the search. The given valuation is not modified during the search. Before accessing
   * the "left child" (changing value at given index to true) in the search tree it is copied to be used as a starting
   * point for the "right child" (changing value at given index to false).
   *
   * @param formula  Formula to be solved.
   * @param v        Current valuation.
   * @param i        Index of the variable to be changed.
   * @param solution Solution found.
   */
  private static void findSolution(Formula formula, Valuation v, int i, Valuation solution) {
    if (i > v.size() || solution.size() > 0) {
      return;
    }

    if (formula.eval(v)) {
      for (var currVar : v.getAllVariables()) {
        solution.add(currVar, v.getValue(currVar));
      }
    }

    if (i == v.size()) {
      return;
    }

    final var valCopy = new Valuation();
    for (var currVar : v.getAllVariables()) {
      valCopy.add(currVar, v.getValue(currVar));
    }

    valCopy.setValueOnIndex(i, true);
    findSolution(formula, valCopy, i + 1, solution);

    valCopy.setValueOnIndex(i, false);
    findSolution(formula, valCopy, i + 1, solution);
  }
}
