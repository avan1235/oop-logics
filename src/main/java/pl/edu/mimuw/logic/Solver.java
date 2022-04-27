package pl.edu.mimuw.logic;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Solver {
    private Solver(){}

    public static Valuation solve(Formula formula) {
        Set<String> set = formula.allVariables();
        String[] empty = new String[0];
        String[] arr = set.toArray(empty);
        int size = arr.length;
        if (size == 0) {
            return null;
        }
        boolean[] keys = new boolean[size];
        for (int i = 0; i < (1 << size); i++) {
            Map<String,Boolean> map = new HashMap<String,Boolean>();
            for(int j=0; j<size; j++){
                keys[j] = ((i%2)==0);
                i=i/2;
                map.put(arr[j],keys[j]);
            }
            var currentValuation = new Valuation(map);
            if(formula.eval(currentValuation)){
                return currentValuation;
            }
        }
        return null;
    }
}
