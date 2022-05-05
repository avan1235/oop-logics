package pl.edu.mimuw.logic;
import java.util.HashSet;

public class Implies extends TwoArgumentFormula {
    public Implies(Formula firstFormula, Formula secondFormula) {
        super(firstFormula, secondFormula);
    }
    public boolean eval(Valuation valuation) {
        return !(firstFormula.eval(valuation) && !secondFormula.eval(valuation));
    }
    public String toString() {
        var s = new StringBuilder();
        s.append("(" + this.firstFormula.toString() + ")");
        s.append(" => ");
        s.append("(" + this.secondFormula.toString() + ")");
        return s.toString();
    }
}