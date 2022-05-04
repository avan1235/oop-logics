package pl.edu.mimuw.logic;

import java.util.HashMap;
import java.util.Map;

public class Valuation {
  private final HashMap<String, Boolean> hashMap;

  public Valuation(){
    this.hashMap = new HashMap<String, Boolean>();
  }

  public boolean get(String s){
    return hashMap.get(s);
  }

  public void set(String s, boolean v){
    hashMap.put(s, v);
  }
}
