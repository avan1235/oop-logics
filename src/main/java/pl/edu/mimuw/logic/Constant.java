package pl.edu.mimuw.logic;

import java.util.HashSet;
import java.util.Set;

public class Constant extends OneArgumentFormula {
    private boolean value;
    public Constant(boolean value) {
        if (value) {
            name = "1";
        } else {
            name = "0";
        }
        this.value = value;
    }

    @Override
    public Set<String> allVariables() {
        return new HashSet<>();
    }

    @Override
    public boolean eval(Valuation valuation) {
        return value;
    }

}
