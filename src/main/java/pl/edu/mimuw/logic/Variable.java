package pl.edu.mimuw.logic;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class Variable implements Formula{

  public final String var;

  public Variable(String var){
    this.var = var;
  }

  @Override
  public boolean eval(Valuation valuation) {
    return valuation.getValue(this.var);
  }

  @Override
  public Set<String> getVariables() {
    return Collections.singleton(this.var);
  }
}
