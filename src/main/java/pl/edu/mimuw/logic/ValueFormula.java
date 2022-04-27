package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValueFormula implements Formula {
  public final boolean value;
  public ValueFormula(boolean value) {
    this.value = value;
  }
  @Override
  public boolean eval(Valuation v){
    return value;
  }

  @Override
  public String toString(){
    return value ? "true" : "false";
  }

  @Override
  public Set<String> collectVariables(){ return new HashSet<>(); }
}
