package pl.edu.mimuw.logic;
import java.util.*;

public class ConstantTrue implements Formula {
  public ConstantTrue(){

  }

  public boolean eval(Valuation valuation){
    return true;
  }
  public String toString(){
    return "true";
  }

  public Set <String> variables() {
    return new HashSet<String>();
  }

}
