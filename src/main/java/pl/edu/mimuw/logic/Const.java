package pl.edu.mimuw.logic;


import java.util.Set;
import java.util.TreeSet;

public class Const implements Formula{
  private final boolean val;

  public Const(boolean b){
    this.val = b;
  }
  public boolean eval(Valuation valuation){
    return val;
  }

  public String toString(){
    if(val)
      return "1";
    else
      return "0";
  }

  @Override
  public Set<String> getDependencies() {
    return new TreeSet<String>();
  }
}
