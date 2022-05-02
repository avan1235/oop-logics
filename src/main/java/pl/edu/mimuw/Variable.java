package pl.edu.mimuw;

import java.util.HashMap;
import java.util.HashSet;

public class Variable extends Formula{
  protected String name;

  public Variable(String name) {
    this.name=name;
  }

@Override
  public boolean eval(HashMap<String, Boolean> data){
    return data.get(this.name);
  }

  public String toString() {
    return this.name.substring(0);
  }
}

