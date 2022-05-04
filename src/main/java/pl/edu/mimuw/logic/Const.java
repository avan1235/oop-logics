package pl.edu.mimuw.logic;

import java.util.Collections;
import java.util.Set;

public class Const implements Formula{

  final private boolean bool;

  public Const(boolean bool){
    this.bool = bool;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return this.bool;
  }

  @Override
  public Set<String> getVariables() {
    return Collections.emptySet();
  }

  @Override
  public String toString(){
    if(this.bool){
      return "true";
    }else{
      return "false";
    }
  }

}
