package pl.edu.mimuw.logic;


import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Var implements Formula{
  private final String name;

  public Var(String s){
    this.name = s;
  }
  public boolean eval(Valuation valuation){
    return valuation.get(this.name);
  }

  public String toString(){
    return name;
  }

  @Override
  public Set<String> getDependencies() {
    TreeSet<String> S = new TreeSet<String>();
    S.add(this.name);
    return S;
  }
}
