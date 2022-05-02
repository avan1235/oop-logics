package pl.edu.mimuw;

import java.util.HashMap;

public class Or extends Two{

  public Or(Formula l, Formula r) {
    super(l, r);
    this.name="OR";
  }

  @Override
  public boolean eval(HashMap<String, Boolean> data){
    return (this.left.eval(data) || this.right.eval(data));
  }
}
