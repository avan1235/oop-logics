package pl.edu.mimuw.logic;

import java.util.*;

public class Solver {
  private static Boolean[] valToBoolean(Valuation val, List<Variable> variables) {
    Boolean[] res = new Boolean[variables.size()];
    int i = 0;

    for (Variable variable : variables)
      res[i++] = val.get(variable.getName());

    return res;
  }

  private static Valuation valFromBoolean(Boolean[] tried, List<Variable> variables) {
    Valuation gen = new Valuation();
    int i = 0;

    for (Variable variable : variables)
      gen.add(variable.getName(), tried[i++]);

    return gen;
  }

  private static Valuation allFalseValuation(List<Variable> variables) {
    Valuation gen = new Valuation();
    for (Variable var : variables)
      gen.add(var.getName(), false);
    return gen;
  }

  public static Valuation solveBrutally(Formula formula) {
    List<Variable> variables = new ArrayList<>(formula.getVariables());
    Queue<Valuation> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    Valuation curr = allFalseValuation(variables);
    queue.add(curr);

    while (!queue.isEmpty()) {
      curr = queue.poll();
      if (formula.eval(curr)) return curr;
      generate(curr, queue, visited, variables);
    }

    return null;
  }

  private static void generate(Valuation val, Queue<Valuation> queue,
                               Set<Integer> visited, List<Variable> variables) {

    Boolean[] tried = valToBoolean(val, variables);

    for (int i = 0; i < tried.length; i++) {
      tried[i] = !tried[i];
      if (!visited.contains(Arrays.hashCode(tried))) {
        queue.add(valFromBoolean(tried, variables));
        visited.add(Arrays.hashCode(tried));
      }
      tried[i] = !tried[i]; // revert change
    }
  }
}
