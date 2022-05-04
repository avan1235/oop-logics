package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public abstract class Operator1Arg implements Formula {
  protected final String name;
  protected final Formula child;

  protected final Formula simpleChild;

  public Operator1Arg(String name, Formula child) {
    this.name = name;
    this.child = child;

    this.simpleChild = this.child.simplify();
  }

  public Set<Variable> findVariables() {
    return child.findVariables();
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name + " (" + child.toString() + ")";
  }

}
