package pl.edu.mimuw.logic;

import java.util.ArrayList;

public interface Formula {

  boolean eval(Valuation valuation);

  ArrayList<FormulaVariable> variables();
}
