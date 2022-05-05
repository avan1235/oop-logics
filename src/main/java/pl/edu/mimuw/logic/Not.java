package pl.edu.mimuw.logic;
import java.util.HashSet;

public class Not extends OneArgumentFormula {
    public Not(Formula formula) {
        this.formula = formula;
    }
    public boolean eval(Valuation valuation) {
        return !this.formula.eval(valuation);
    }
    public String toString() {
        return "~(" + this.formula.toString() + ")";
    }
}