package pl.edu.mimuw.logic;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public abstract class OneArgFormula implements Formula {
  protected final Formula f;

  public OneArgFormula(Formula a) {
    this.f = a;
  }

  public abstract boolean eval(Valuation valuation);

  @Override
  public Set<String> getDependencies() {
    return this.f.getDependencies();
  }
}
