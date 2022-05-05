package pl.edu.mimuw.logic;

public class And extends TwoArgumentFormula {
    public And(Formula firstFormula, Formula secondFormula) {
        super(firstFormula, secondFormula);
    }
    public boolean eval(Valuation valuation) {
        return (firstFormula.eval(valuation) && secondFormula.eval(valuation));
    }
    public String toString() {
        var s = new StringBuilder();
        s.append("(" + this.firstFormula.toString() + ")");
        s.append(" & ");
        s.append("(" + this.secondFormula.toString() + ")");
        return s.toString();
    }
}