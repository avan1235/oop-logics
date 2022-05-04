package pl.edu.mimuw.logic;

import java.util.ArrayList;

import static java.util.Collections.sort;

public abstract class DoubleArg implements Formula{
  protected Formula left;
  protected Formula right;
  public DoubleArg(Formula left,Formula right){
    this.left=left;this.right=right;
  }
  @Override
  public ArrayList<String> getAllVariables() {
    Formula temp=this;
    var list=this.left.getAllVariables();
    list.addAll(this.right.getAllVariables());
    sort(list);

    return list;
  }

  @Override
  public String toString() {
    var sb=new StringBuilder();
    sb.append("Double argument formula with children:\n").append("left: ").append(this.left.toString()).append("right ").append(this.right.toString());
    return sb.toString();
  }
}
