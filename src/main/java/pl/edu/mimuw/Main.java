package pl.edu.mimuw;

import pl.edu.mimuw.logic.*;

import java.text.Normalizer;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    Formula f = FormulaFactory.not(FormulaFactory.or(FormulaFactory.var("x"), FormulaFactory.f()));
    Formula f2 = FormulaFactory.and(FormulaFactory.var("x"), FormulaFactory.iff(FormulaFactory.var("x"), FormulaFactory.t()));

    HashMap<String, Boolean> m = new HashMap<>();
    m.put("x", true);
    Valuation xtrue = new Valuation(m);
    m.put("x", false);
    Valuation xfalse = new Valuation(m);


    System.out.println(f);
    System.out.print(" - x=true then ");
    System.out.print(f.eval(xtrue));
    System.out.print(" and x=false then ");
    System.out.println(f.eval(xfalse));

    System.out.println(f2);
    System.out.print(" - x=true then ");
    System.out.print(f2.eval(xtrue));
    System.out.print(" and x=false then ");
    System.out.println(f2.eval(xfalse));

    Formula f3 = FormulaFactory.implies(f, f2);
    System.out.println(f3);
    System.out.print(" - x=true then ");
    System.out.print(f3.eval(xtrue));
    System.out.print(" and x=false then ");
    System.out.println(f3.eval(xfalse));

    Formula f4 = FormulaFactory.iff(f3, FormulaFactory.not(FormulaFactory.var("varY")));
    System.out.println(f4);
    try {
      Valuation valuation = Solver.solve(f4);
      System.out.print(" - Solution is: ");
      System.out.println(valuation);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }

    System.out.println(" ");
    Main.printTests();
  }

  public static void printTests(){
    Formula formula = FormulaFactory.or(FormulaFactory.f(), FormulaFactory.and(FormulaFactory.var("x"), FormulaFactory.not(FormulaFactory.var("x"))));
    System.out.println("test1: ");
    System.out.println(formula);

    formula = FormulaFactory.or(FormulaFactory.var("x"), FormulaFactory.not(FormulaFactory.var("x")));
    formula = FormulaFactory.implies(formula, FormulaFactory.or(FormulaFactory.var("y"), FormulaFactory.not(FormulaFactory.var("y"))));
    System.out.println("test2: ");
    System.out.println(formula);


    formula = FormulaFactory.iff(FormulaFactory.var("x"), FormulaFactory.not(FormulaFactory.var("y")));
    formula = FormulaFactory.and(formula, FormulaFactory.implies(FormulaFactory.var("y"), FormulaFactory.var("x")));
    System.out.println("test3: ");
    System.out.println(formula);
  }
}
