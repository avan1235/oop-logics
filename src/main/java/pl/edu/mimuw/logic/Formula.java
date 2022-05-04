package pl.edu.mimuw.logic;

import java.util.ArrayList;

public interface Formula {
  ArrayList<String> getAllVariables();

  boolean eval(Valuation valuation);

  @Override
  String toString();
}
