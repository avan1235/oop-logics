package pl.edu.mimuw;

import java.util.HashMap;

public class Implies extends Two{

  public Implies(Formula l, Formula r) {
    super(l, r);
    this.name="IMPLIES";
  }

  @Override
  public boolean eval(HashMap<String, Boolean> data){
    return (!(this.left.eval(data) && !this.right.eval(data)));
  }
}
