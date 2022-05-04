package pl.edu.mimuw.logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import static java.lang.Math.pow;

public class Solver {
  public static Valuation solve(Formula form) {
    Set<String> vars = form.getDependencies();
    int N = vars.size();
    for (int i = 0; i < pow(2, N); i++) {
      Valuation testVal = new Valuation();
      int bitHolder = i;
      for (String s : vars) {
        testVal.set(s, bitHolder % 2 == 1);
        bitHolder /= 2;
      }
      if (form.eval(testVal))
        return testVal;
    }
    return null;
  }
}
