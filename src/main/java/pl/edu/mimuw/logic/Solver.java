package pl.edu.mimuw.logic;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


public class Solver {
    public Solver() {

    }
    public static boolean giveSolution(Valuation val, Variable[] variables, Formula f, int index, boolean isResult) {
        if(!isResult) {
            if(index != variables.length - 1) {
                val.setValue(variables[index], true);
                giveSolution(val, variables, f, index + 1, isResult);
                if(!isResult) {
                    val.setValue(variables[index], false);
                    giveSolution(val, variables, f, index + 1, isResult);
                }

            }
            else {
                val.setValue(variables[index], true);
                isResult = f.eval(val);
                if(!isResult) {
                    val.setValue(variables[index], false);
                    isResult = f.eval(val);
                }
            }
        }
        return isResult;
    }
    public static Set<Variable> getVariables(Formula f) {
        var s = f.getVariables();

        return s;
    }
    public static Solution solution(Formula f) {
        var s = f.getVariables();
        Variable[] arr = new Variable[s.size()];
        int i = 0;
        for (Variable x : s)
            arr[i++] = x;
        var val = new Valuation();
        var isSolution = giveSolution(val, arr, f, 0, false);
        return new Solution(val, isSolution);
    }
}