package pl.edu.mimuw;
import static pl.edu.mimuw.logic.FormulaFactory.*;
import static pl.edu.mimuw.logic.Solver.*;

import pl.edu.mimuw.logic.Valuation;
import pl.edu.mimuw.logic.Variable;
public class Main {

  public static void main(String[] args) {
    var v = var("v");
    var f = implies(v,f());
    for(int i = 0; i < 20; i++) {
      f =  implies(v, f);
    }
    var s = solution(f);
    var exp = new Valuation();
    exp.setValue(v, false);
    System.out.println(exp);
    System.out.println(s.getValuation());
  }
}
