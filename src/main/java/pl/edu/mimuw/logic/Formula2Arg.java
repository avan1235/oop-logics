package pl.edu.mimuw.logic;

import java.util.List;
import java.util.Set;

public abstract class Formula2Arg implements Formula {
  protected Formula formula1, formula2;
  public Formula2Arg(Formula formula1, Formula formula2) {
    this.formula1 = formula1;
    this.formula2 = formula2;
  }

  @Override
  public Set<String> collectVariables(){
    Set<String> res = formula1.collectVariables();
    res.addAll(formula2.collectVariables());
    return res;
  }
}
