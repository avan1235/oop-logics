package pl.edu.mimuw;

import java.util.ArrayList;

import static pl.edu.mimuw.FormulaFactory.*;

public class Main {

  public static void main(String[] args) {

    FormulaFactory ff = new FormulaFactory();
    Variable p = new Variable("p");
    Variable q = new Variable("q");
    Variable r = new Variable("r");
    ArrayList<Formula> lista = new ArrayList<Formula>();
    lista.add(iff(and(p, q), and(q, p)));
    lista.add(iff(or(p, q), or(q, p)));
    lista.add(iff(not(and(p, q)), or(not(p), not(q))));
    lista.add(iff(not(or(p, q)), and(not(p), not(q))));
    Formula g = iff(or(p, and(q, r)), and(or(p, q), or(p, r)));

    //tutaj jakieś przykłady typu prawa de morgana
    for (int i = 0; i < lista.size(); i++) {
      assign(p, true);
      assign(q,true);
      evaluate(lista.get(i));

      assign(q, false);
      evaluate(lista.get(i));

      assign(p, false);
      evaluate(lista.get(i));

      assign(q, true);
      evaluate(lista.get(i));
      //throw new IllegalStateException("TODO: show formulas pretty-printed examples");
    }

    evaluate(implies(True(), False()));
    evaluate(and(or(True(), False()), not(and(True(), False()))));
  }
}
