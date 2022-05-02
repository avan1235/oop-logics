package pl.edu.mimuw;

import java.util.HashMap;

public class And extends Two{

  public And(Formula l, Formula r) {
    super(l, r);
    this.name="AND";
  }

  @Override
  public boolean eval(HashMap<String, Boolean> data){
    return (this.left.eval(data) && this.right.eval(data));
  }
}
