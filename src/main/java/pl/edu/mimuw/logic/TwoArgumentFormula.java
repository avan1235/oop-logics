package pl.edu.mimuw.logic;
import java.util.Set;
import java.util.HashSet;

abstract class TwoArgumentFormula implements Formula {
    protected Formula firstFormula;
    protected Formula secondFormula;
    public TwoArgumentFormula(Formula firstFormula, Formula secondFormula) {
        this.firstFormula = firstFormula;
        this.secondFormula = secondFormula;
    }
    public Formula getFirstFormula() {
        return firstFormula;
    }
    public Formula getSecondFormula() {
        return secondFormula;
    }
    public HashSet<Variable> getVariables() {
        var s = new HashSet<Variable>() {
            {
                addAll(firstFormula.getVariables());
                addAll(secondFormula.getVariables());
            }
        };
        return s;
    }
}