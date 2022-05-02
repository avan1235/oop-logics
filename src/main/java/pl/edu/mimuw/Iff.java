package pl.edu.mimuw;

import java.util.HashMap;

public class Iff extends Two{

  public Iff(Formula l, Formula r) {
    super(l, r);
    this.name="IFF";
  }

  @Override
  public boolean eval(HashMap<String, Boolean> data){
    return (this.left.eval(data) == this.right.eval(data));
  }
}
