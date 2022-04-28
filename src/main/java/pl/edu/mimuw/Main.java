package pl.edu.mimuw;

import pl.edu.mimuw.logic.FormulaFactory;
import pl.edu.mimuw.logic.Solver;
import pl.edu.mimuw.logic.Valuation;

public class Main {

  private static void print(String[] var, boolean[] val) {
    for (int i = 0; i < var.length; i++) {
      System.out.println(var[i] + "->" + val[i]);
    }
  }

  public static void main(String[] args) {
    var f = new FormulaFactory();
    var andForm = f.and(f.var("l"), f.var("r"));

    var valuation = new Valuation();
    valuation.SetValue("l", true);
    valuation.SetValue("r", true);

    System.out.println(andForm.represent() + "=" + andForm.eval(valuation));

    var solver = new Solver();
    var val = solver.solve(andForm);
    print(andForm.getVars().toArray(new String[0]), val);

    var form = f.iff(andForm, f.implies(f.var("x"), f.var("l")));
    System.out.println(form.represent());
    val = solver.solve(form);
    print(form.getVars().toArray(new String[0]), val);

    var iffForm = f.and(f.var("l"), f.var("r"));
    var orForm = f.or(f.var("l"), f.var("r"));
    var impForm = f.iff(f.f(), f.implies(orForm, iffForm));
    System.out.println(impForm.represent());
    print(impForm.getVars().toArray(new String[0]), solver.solve(impForm));

    iffForm = f.and(f.var("l"), f.var("r"));
    orForm = f.or(f.var("l"), f.var("r"));
    impForm = f.iff(f.f(), f.implies(orForm, iffForm));
    var and = f.and(f.var("x"), f.var("y"));
    var and2 = f.and(f.var("z"), f.var("m"));
    var impForm2 = f.implies(f.t(), f.and(and, and2));
    form = f.and(impForm, impForm2);
    System.out.println(form.represent());
    print(form.getVars().toArray(new String[0]), solver.solve(form));
  }
}
