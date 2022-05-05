package pl.edu.mimuw.logic;
import java.util.Set;
import java.util.HashSet;

abstract class OneArgumentFormula implements Formula {
    protected Formula formula;
    public Formula getFormula() {
        return formula;
    }
    public HashSet<Variable> getVariables() {
        var s = new HashSet<Variable>() {
            {
                addAll(formula.getVariables());
            }
        };
        return s;
    }
}