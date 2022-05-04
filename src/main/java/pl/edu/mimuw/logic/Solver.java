package pl.edu.mimuw.logic;

import java.util.*;

public class Solver {
  //private Formula formula;

  public Solver() {
    //this.formula = formula;
  }

  public static HashMap<String, Boolean> getCorrectValuation(Formula formula) {
    var result = new HashMap<String, Boolean>();
    Boolean found = false;
    Set<String> vals = formula.variables();
    if(vals.size() == 0){
      Valuation valuation = new Valuation(new HashMap<String, Boolean>());
      if(formula.eval(valuation))
        return result;
      else
        return null;
    }
    String[] valsArray = vals.toArray(new String[vals.size()]);
    for (int i = 1 << vals.size() - 1; i >= 0; i--) {
      var mapa = new HashMap<String, Boolean>();
      for (int j = 0; j < vals.size(); j++) {
        int currentNumber = 1 << j;
        int andResult = currentNumber & i;
        if (andResult != 0) {
          mapa.put(valsArray[j], true);
        } else {
          mapa.put(valsArray[j], false);
        }
      }
      Valuation valuation = new Valuation(mapa);
      if(formula.eval(valuation) == true){
        found = true;
        result = mapa;
      }
    }
    if(found)
      return  result;
    else
    return null;
  }
}
