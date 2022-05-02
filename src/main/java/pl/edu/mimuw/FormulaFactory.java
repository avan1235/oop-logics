package pl.edu.mimuw;

import java.util.HashMap;

public class FormulaFactory {
  protected static HashMap<String, Boolean> values;
  public FormulaFactory(){
    values = new HashMap<String, Boolean>();
  }

  public static Formula True(){return new True();}
  public static Formula False(){return new False();}
  public static Formula newVariable(String s) {
    return new Variable(s);
  }
  public static Formula and(Formula l, Formula r) {
    return new And(l, r);
  }
  public static Formula or(Formula l, Formula r) {
    return new Or(l, r);
  }
  public static Formula iff(Formula l, Formula r) {
    return new Iff(l, r);
  }
  public static Formula implies(Formula l, Formula r) {
    return new Implies(l, r);
  }
  public static Formula not(Formula f) {
    return new Not(f);
  }

  public static void assign(Variable v, boolean b) {
    values.put(v.name, b);
  }
  public static boolean evaluate(Formula f) {
    boolean res = f.eval(values);
    if (res)
      System.out.println(f.toString() + " is a true statement");
    else
      System.out.println(f.toString() + " is a false statement");
    return res;
  }
}
