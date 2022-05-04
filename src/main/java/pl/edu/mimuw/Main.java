package pl.edu.mimuw;

import pl.edu.mimuw.logic.Formula;
import pl.edu.mimuw.logic.Valuation;

import pl.edu.mimuw.logic.FormulaFactory;
import pl.edu.mimuw.logic.Var;


public class Main {

  public static void main(String[] args) {
    Valuation v = new Valuation();
    Formula hamlet = FormulaFactory.or(new Var("to_be"), FormulaFactory.neg(new Var("to_be")));
    System.out.println(hamlet);

  }
}
