package pl.edu.mimuw.logic;

import java.util.Set;

public abstract class TwoArgumentsFormula implements Formula{
  protected final Formula left;
  protected final Formula right;
  protected final String operation;


  protected TwoArgumentsFormula(Formula left, Formula right, String operation) {
    this.left = left;
    this.right = right;
    this.operation = operation;
  }

  @Override
  public Set<String> getVariables(){
    var result = this.left.getVariables();
    result.addAll(this.right.getVariables());
    return result;
  }

  @Override
  public String toString(){
    return this.left + " " + this.operation + " " + this.right;
  }
}
