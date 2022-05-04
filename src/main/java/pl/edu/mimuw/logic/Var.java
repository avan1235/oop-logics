package pl.edu.mimuw.logic;

import java.util.ArrayList;

public class Var implements Formula{
  private final String name;
  public Var(String name){
    this.name=name;
  }
  @Override
  public boolean eval(Valuation valuation) {
    return valuation.getVariableMap().get(name);
  }

  @Override
  public ArrayList<String> getAllVariables() {
    var singleton=new ArrayList<String>(1);
    singleton.add(this.name);
    return singleton;
  }

  @Override
  public String toString(){
    var sb=new StringBuilder();
    sb.append("Variable named ").append("\"").append(this.name).append("\"");
    return sb.toString();
  }
}
