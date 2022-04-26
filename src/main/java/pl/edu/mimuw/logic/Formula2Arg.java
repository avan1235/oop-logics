package pl.edu.mimuw.logic;
import java.util.*;

public abstract class Formula2Arg implements Formula{
  protected Formula f1;
  protected Formula f2;
  public Formula2Arg(Formula f1, Formula f2)
  {
    this.f1 = f1;
    this.f2 = f2;
  }

  @Override
  public abstract boolean eval(Valuation valuation);

  @Override
  public abstract String toString();

  @Override
  public Set <String> variables(){
    Set <String> set1 = f1.variables();
    Set <String> set2 = f2.variables();
    for(String element: set2){
      set1.add(element);
    }
    return set1;
  }
}
