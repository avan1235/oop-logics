package pl.edu.mimuw.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solver {

  public ArrayList<FormulaVariable> variables;
  private boolean solved;

  public Solver(Formula f) {
    this.variables = f.variables();
    this.solved = false;
  }

  private ArrayList<Boolean> solve2(Formula f, ArrayList<Boolean> values) {
    if (!this.solved) {
      if (values.size() == this.variables.size()) {
        Map<FormulaVariable, Boolean> valuationMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) valuationMap.put(this.variables.get(i), values.get(i));
        if (f.eval(new Valuation(valuationMap))) {
          this.solved = true;
          return values;
        }
      } else {
        ArrayList<Boolean> valuesf = new ArrayList<>(); //values + false
        valuesf.addAll(values);
        valuesf.add(false);
        ArrayList<Boolean> valuest = new ArrayList<>(); //values + true
        valuest.addAll(values);
        valuest.add(true);
        ArrayList<Boolean> tmp = this.solve2(f, valuesf);
        if (this.solved) return tmp;
        tmp = this.solve2(f, valuest);
        if (this.solved) return tmp;
      }
    }
    return new ArrayList<>();
  }

  public Valuation solve(Formula f) {
    ArrayList<Boolean> values = this.solve2(f, new ArrayList<>());
    if (values.size() == this.variables.size()) {
      Map<FormulaVariable, Boolean> valuationMap = new HashMap<>();
      for (int i = 0; i < values.size(); i++) {
        valuationMap.put(this.variables.get(i), values.get(i));
      }
      this.solved = false;
      return new Valuation(valuationMap);
    } else return null;
  }
}
