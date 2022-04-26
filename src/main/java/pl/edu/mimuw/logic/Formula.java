package pl.edu.mimuw.logic;

import java.util.*;

public interface Formula {

  boolean eval(Valuation valuation);

  String toString();

  Set <String> variables();
}
