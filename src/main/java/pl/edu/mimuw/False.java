package pl.edu.mimuw;

import java.util.HashMap;

public class False extends Formula{
  private final boolean val;

  public False(){
    this.val=false;
  }
  public boolean eval(HashMap<String, Boolean> data) {
    return false;
  }
  public String toString(){return "FALSE";}
}
