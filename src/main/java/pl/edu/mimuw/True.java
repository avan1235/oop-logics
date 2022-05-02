package pl.edu.mimuw;

import java.util.HashMap;

public class True extends Formula{
  private final boolean val;
  public True(){
    this.val=true;
  }
  public boolean eval(HashMap<String, Boolean> data) {
    return true;
  }
  public String toString(){return "TRUE";}
}
