package pl.edu.mimuw.logic;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class VariableFormula implements Formula {
  public final String variable;
  public VariableFormula(String var){
    variable = var;
  }
  @Override
  public boolean eval(Valuation v) {
    return v.getValue(variable);
  }
  @Override
  public String toString(){
    return variable;
  }

  @Override
  public Set<String> collectVariables(){
    return new HashSet<>(List.of(variable));
  }
}
