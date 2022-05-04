package pl.edu.mimuw.logic;

import java.text.Normalizer;
import java.util.Collections;
import java.util.Set;

public abstract class TwoArgFormula implements Formula{
  protected final Formula f1;
  protected final Formula f2;

  public TwoArgFormula(Formula a, Formula b){
    this.f1 = a;
    this.f2 = b;
  }
  public abstract boolean eval(Valuation valuation);

  public Set<String> getDependencies() {
    Set<String> S1 = this.f1.getDependencies();
    Set<String> S2 = this.f2.getDependencies();
    for(var s: S1)
      S2.add(s);
    return S2;
  }
}
