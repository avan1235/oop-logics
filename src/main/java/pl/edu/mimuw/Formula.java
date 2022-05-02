package pl.edu.mimuw;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Formula {

  public abstract boolean eval(HashMap<String, Boolean> data);

}
