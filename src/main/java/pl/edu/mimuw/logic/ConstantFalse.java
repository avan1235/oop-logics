package pl.edu.mimuw.logic;
import java.util.*;

public class ConstantFalse implements Formula {
  public ConstantFalse(){

  }
  public boolean eval(Valuation valuation){
    return false;
  }
  public String toString(){
    return "false";
  }
  public Set <String> variables() {
    return new HashSet<String>();
  }
}
