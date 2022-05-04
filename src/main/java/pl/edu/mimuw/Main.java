package pl.edu.mimuw;

import pl.edu.mimuw.logic.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Formula x = FormulaFactory.var("x");
    Formula y = FormulaFactory.var("y");
    Formula And1 = FormulaFactory.and(x, y);
    Formula Or1 = FormulaFactory.or(x, y);
    Formula Impl1 = FormulaFactory.implies(And1, Or1);

    HashMap<String, Boolean> m = new HashMap<>();
    m.put("x", true);
    m.put("y", false);
    Valuation Val1 = new Valuation(m);
    System.out.println(Impl1);
    System.out.println(Val1);
    System.out.println(Impl1.eval(Val1));

    HashMap<String, Boolean> m2 = new HashMap<>();
    m2.put("y", true);
    m2.put("x", true);
    Valuation Val2 = new Valuation(m2);
    System.out.println(Impl1);
    System.out.println(Val2);
    System.out.println(Impl1.eval(Val2));
    Formula Iff1 = FormulaFactory.iff(Impl1, x);
    Formula true1 = FormulaFactory.t();
    Formula finalFormula = FormulaFactory.and(Iff1, true1);
    //sout all possible logic types
    System.out.println(finalFormula);
  }
}
