package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public abstract class Operator2Arg implements Formula {
  protected final String name;
  protected final Formula left;
  protected final Formula right;

  protected final Formula simpleLeft;
  protected final Formula simpleRight;

  public Operator2Arg(String name, Formula left, Formula right) {
    this.name = name;
    this.left = left;
    this.right = right;

    this.simpleLeft = left.simplify();
    this.simpleRight = right.simplify();
  }

  public Set<Variable> findVariables() {
    Set<Variable> newSet = null;

    var leftVariables = left.findVariables();
    if (leftVariables != null ) {
      newSet = leftVariables;
    }

    var rightVariables = right.findVariables();
    if (rightVariables != null) {
      if (newSet != null ) {
        newSet.addAll(right.findVariables());
      }
      else {
        newSet = rightVariables;
      }
    }

    return newSet;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return "(" + left.toString() + ") " + name + " (" + right.toString() + ")";
  }

}
