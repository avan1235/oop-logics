package pl.edu.mimuw.logic;

import java.util.List;
import java.util.Set;

public abstract class Formula1Arg implements Formula {
  protected Formula formula;
  public Formula1Arg(Formula formula) {
    this.formula = formula;
  }

  @Override
  public Set<String> collectVariables(){
    return formula.collectVariables();
  }
}
