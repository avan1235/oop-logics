package pl.edu.mimuw;

import java.util.HashMap;
import java.util.HashSet;

public class Not extends Formula{
  protected Formula inside;

  public Not(Formula f){
    this.inside=f;
  }

  public boolean eval(HashMap<String, Boolean> data){
    return !(this.inside.eval(data));
  }

  public String toString(){
    return "(NOT " + this.inside.toString() + ")";
  }
}
